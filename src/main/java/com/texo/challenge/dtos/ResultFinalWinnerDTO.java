package com.texo.challenge.dtos;

import java.util.List;

public class ResultFinalWinnerDTO {
	
	private List<WinnerDTO> min;
	private List<WinnerDTO> max;
	
	public ResultFinalWinnerDTO() {}

	public ResultFinalWinnerDTO(List<WinnerDTO> min, List<WinnerDTO> max) {
		super();
		this.min = min;
		this.max = max;
	}

	public List<WinnerDTO> getMin() {
		return min;
	}
	public void setMin(List<WinnerDTO> min) {
		this.min = min;
	}
	public List<WinnerDTO> getMax() {
		return max;
	}
	public void setMax(List<WinnerDTO> max) {
		this.max = max;
	}
}
