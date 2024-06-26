package com.texo.challenge.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AwardModel(
		@NotNull(message = "Invalid year: empty year")  Integer year,
		@NotBlank(message = "Invalid title: empty title") String title,
		@NotBlank(message = "Invalid studio: empty studio") String studio,
		@NotBlank(message = "Invalid producer: empty producer") String producer, 
		String winner) {
}
