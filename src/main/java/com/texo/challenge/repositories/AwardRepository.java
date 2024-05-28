package com.texo.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.texo.challenge.entities.Award;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long>{

}
