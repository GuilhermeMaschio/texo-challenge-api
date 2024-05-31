package com.texo.challenge.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texo.challenge.models.AwardModel;
import com.texo.challenge.entities.Award;
import com.texo.challenge.entities.Producer;
import com.texo.challenge.entities.Studio;
import com.texo.challenge.exceptions.BusinessExceptions;
import com.texo.challenge.repositories.AwardRepository;

import jakarta.transaction.Transactional;

@Service
public class AwardService {

	private static final String WINNER = "YES";

	@Autowired
	private AwardRepository awardRepository;

	@Autowired
	private ProducerService producerService;

	@Autowired
	private StudioService studioService;

	@Transactional
	public Award save(AwardModel movieDTO) throws BusinessExceptions{
		var award = new Award();
		
		try {
			
			award.setProducers(saveProducer(getListProducer(movieDTO.producer())));
			award.setStudios(saveStudio(getListStudio(movieDTO.studio())));
			award.setYear(movieDTO.year());
			award.setTitle(movieDTO.title());
			award.setWinner(validadeWinner(movieDTO.winner()));
			
			award = awardRepository.saveAndFlush(award);
		}catch (Exception e) {
			throw new BusinessExceptions("Insert or update error: " + e.getMessage());
		}

		return award;
	}
	
	private List<Studio> getListStudio(String stringStudio){
		List<Studio> studios = new ArrayList<>();
		List<String> studioListStr = stringToArrayList(stringStudio);
		studioListStr.forEach(s -> studios.add(new Studio(s)));
		return studios;
	}
	
	private List<Producer> getListProducer(String stringProducer){
		List<Producer> producers = new ArrayList<>();
		List<String> studioListStr = stringToArrayList(stringProducer);
		studioListStr.forEach(p -> producers.add(new Producer(p)));
		return producers;
	}

	private List<String> stringToArrayList(String parameters) {

		List<String> finalList = new ArrayList<>();
		String[] parts = parameters.split(" and ");
		for (String part : parts) {
			finalList.addAll(Arrays.asList(part.split(", ")));
		}
		return finalList;
	}

	private boolean validadeWinner(String winner) {
		boolean bRet = false;
		if (winner != null) {
			bRet = WINNER.equals(winner.toUpperCase());
		}
		return bRet;
	}

	private List<Producer> saveProducer(List<Producer> producers) {
		return this.producerService.saveOrUpdate(producers);
	}

	private List<Studio> saveStudio(List<Studio> studios) {
		return this.studioService.saveOrUpdate(studios);
	}

	public List<Award> getAllAwards() {
		return awardRepository.findAll();
	}
}