package com.texo.challenge.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AwardDTO(
		@NotNull(message = "Invalid year: empty year")  Integer year,
		@NotBlank(message = "Invalid title: empty title") String title,
		@NotBlank(message = "Invalid studios: empty studios") String studios,
		@NotBlank(message = "Invalid producers: empty producers") String producers, 
		String winner) {
}
