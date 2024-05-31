package com.texo.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texo.challenge.models.ResultFinalWinnerModel;
import com.texo.challenge.services.WinnerService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/producers")
public class ResultController {

	@Autowired
	private WinnerService winnerService;
	
	@GetMapping("/awards/min-max")
	public ResponseEntity<ResultFinalWinnerModel> getResultFinalWinner() {
		
		ResultFinalWinnerModel result = winnerService.extractedResult();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
