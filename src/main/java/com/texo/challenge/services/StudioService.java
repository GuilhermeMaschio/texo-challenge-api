package com.texo.challenge.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texo.challenge.entities.Studio;
import com.texo.challenge.repositories.StudioRepository;

import jakarta.transaction.Transactional;

@Service
public class StudioService {

	@Autowired
	private StudioRepository studioRepository;
	
	public List<Studio> saveOrUpdate(List<Studio> studios){
		List<Studio> saveList = new ArrayList<>();
		
		for (Studio studio : studios) {
			saveList.add(this.saveOrUpdate(studio));
		}
		
		return saveList;
	}

	@Transactional
	public Studio saveOrUpdate(Studio studio) {
		Optional<Studio> existingEntity = studioRepository.findByName(studio.getName());

		if (existingEntity.isPresent()) {
			return studioRepository.saveAndFlush(existingEntity.get());
		} else {
			return studioRepository.save(studio);
		}
	}
}
