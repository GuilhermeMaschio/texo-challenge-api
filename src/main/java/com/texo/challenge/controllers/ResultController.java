package com.texo.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texo.challenge.dtos.ResultFinalWinnerDTO;
import com.texo.challenge.services.WinnerService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ResultController {

	@Autowired
	private WinnerService winnerService;
	
	@GetMapping("/result")
	public ResponseEntity<ResultFinalWinnerDTO> getResultFinalWinner() {
		
		ResultFinalWinnerDTO result = winnerService.extractedResult();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
