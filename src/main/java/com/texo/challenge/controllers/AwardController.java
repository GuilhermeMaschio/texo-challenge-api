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

import com.texo.challenge.dtos.AwardDTO;
import com.texo.challenge.dtos.ResultFinalWinnerDTO;
import com.texo.challenge.dtos.WinnerDTO;
import com.texo.challenge.entities.Award;
import com.texo.challenge.enuns.ParameterEnum;
import com.texo.challenge.exceptions.BusinessExceptions;
import com.texo.challenge.services.AwardService;
import com.texo.challenge.services.WinnerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/award")
public class AwardController {

	@Autowired
	private AwardService awardService;
	@Autowired
	private WinnerService winnerService;

	@PostMapping
	public ResponseEntity<Award> saveAward(@RequestBody @Valid AwardDTO awardDTO) throws BusinessExceptions {
		var award = awardService.save(awardDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(award);
	}

	@GetMapping
	public ResponseEntity<List<Award>> getAllUsers() {
		List<Award> awards = this.awardService.getAllAwards();
		return new ResponseEntity<>(awards, HttpStatus.OK);
	}
	
	@GetMapping("/result")
	public ResponseEntity<ResultFinalWinnerDTO> getResultFinalWinner() {
		
		List<WinnerDTO> min = winnerService.getResultWinner(ParameterEnum.ASC.toString());
		List<WinnerDTO> max = winnerService.getResultWinner(ParameterEnum.DESC.toString());
		
		ResultFinalWinnerDTO result = new ResultFinalWinnerDTO();
		result.setMin(min);
		result.setMax(max);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
