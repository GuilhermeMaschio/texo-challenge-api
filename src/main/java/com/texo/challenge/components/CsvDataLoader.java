package com.texo.challenge.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.texo.challenge.dtos.AwardDTO;
import com.texo.challenge.exceptions.BusinessExceptions;
import com.texo.challenge.services.AwardService;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Slf4j
public class CsvDataLoader implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(CsvDataLoader.class);

	@Autowired
	private AwardService awardService;

	@Override
	public void run(String... args) throws Exception {
		ClassPathResource csvResource = new ClassPathResource("doc/movielist.csv");
		FileReader fileReader = new FileReader(csvResource.getFile());
		loadAwardsFromCsv(fileReader);
	}

	private void loadAwardsFromCsv(FileReader fileCSV) throws IOException, BusinessExceptions {
		List<AwardDTO> movieDTOs = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(fileCSV)) {
            // skip the first line
            reader.readLine();

            // read others lines
            String line;
            while ((line = reader.readLine()) != null) {
                
    			String[] splitLine = line.split(";");

    			String year = splitLine[0];
    			String title = splitLine[1];
    			String studio = splitLine[2];
    			String producer = splitLine[3];
    			String winner = null;
    			
    			if(splitLine.length > 4)
    				winner = splitLine[4];
            	
    			movieDTOs.add(new AwardDTO(Integer.valueOf(year), title, studio, producer, winner));
            }
            
            saveAward(movieDTOs);
            
        } catch (IOException e) {
            log.error("Error to read the file: " + e.getMessage());
        }
		
	}

	private void saveAward(List<AwardDTO> movieDTOs) throws BusinessExceptions {
		for (AwardDTO movieDTO : movieDTOs) {
			awardService.save(movieDTO);
		}
		
		 log.info(String.format("Read file ok, %s registers saved successful.", movieDTOs.size()));
	}
}