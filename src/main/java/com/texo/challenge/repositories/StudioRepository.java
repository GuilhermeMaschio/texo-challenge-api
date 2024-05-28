package com.texo.challenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.texo.challenge.entities.Studio;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {
	Optional<Studio> findByName(String name);
	
}
