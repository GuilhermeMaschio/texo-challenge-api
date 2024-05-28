package com.texo.challenge.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texo.challenge.entities.Producer;
import com.texo.challenge.repositories.ProducerRepository;

import jakarta.transaction.Transactional;

@Service
public class ProducerService {

	@Autowired
	private ProducerRepository producerRepository;
	
	public List<Producer> saveOrUpdate(List<Producer> producers) {
		List<Producer> producersSaved = new ArrayList<>();
		
		for (Producer producer : producers) {
			producersSaved.add(this.saveOrUpdate(producer));
		}
		
		return producersSaved;
	}
	
	@Transactional
    public Producer saveOrUpdate(Producer producer) {
        Optional<Producer> existingEntity = producerRepository.findByName(producer.getName());
     
        if (existingEntity.isPresent()) {
            return producerRepository.save(existingEntity.get());
        } else {
            return producerRepository.save(producer);
        }
    }
}
