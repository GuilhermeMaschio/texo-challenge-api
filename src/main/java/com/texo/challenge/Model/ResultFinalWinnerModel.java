package com.texo.challenge.Model;

import java.util.List;

public class ResultFinalWinnerModel {
	
	private List<WinnerModel> min;
	private List<WinnerModel> max;
	
	public ResultFinalWinnerModel() {}

	public ResultFinalWinnerModel(List<WinnerModel> min, List<WinnerModel> max) {
		super();
		this.min = min;
		this.max = max;
	}

	public List<WinnerModel> getMin() {
		return min;
	}
	public void setMin(List<WinnerModel> min) {
		this.min = min;
	}
	public List<WinnerModel> getMax() {
		return max;
	}
	public void setMax(List<WinnerModel> max) {
		this.max = max;
	}
}
