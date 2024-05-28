package com.texo.challenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.texo.challenge.entities.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long>{

	Optional<Producer> findByName(String name);
}
