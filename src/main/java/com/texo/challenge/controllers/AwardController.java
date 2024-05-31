package com.texo.challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texo.challenge.models.AwardModel;
import com.texo.challenge.entities.Award;
import com.texo.challenge.exceptions.BusinessExceptions;
import com.texo.challenge.services.AwardService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/awards")
public class AwardController {

	@Autowired
	private AwardService awardService;

	@PostMapping()
	public ResponseEntity<Award> saveAward(@RequestBody @Valid AwardModel awardDTO) throws BusinessExceptions {
		var award = awardService.save(awardDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(award);
	}

	@GetMapping()
	public ResponseEntity<List<Award>> getAllUsers() {
		List<Award> awards = this.awardService.getAllAwards();
		return new ResponseEntity<>(awards, HttpStatus.OK);
	}

}
