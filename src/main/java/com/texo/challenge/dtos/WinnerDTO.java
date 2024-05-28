package com.texo.challenge.dtos;

public class WinnerDTO {

	private String producer;
	private int interval;
	private int previousWin;
	private int followingWin;

	public WinnerDTO() {
	}

	public WinnerDTO(String producer, int interval, int previousWin, int followingWin) {
		super();
		this.producer = producer;
		this.interval = interval;
		this.previousWin = previousWin;
		this.followingWin = followingWin;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getPreviousWin() {
		return previousWin;
	}

	public void setPreviousWin(int previousWin) {
		this.previousWin = previousWin;
	}

	public int getFollowingWin() {
		return followingWin;
	}

	public void setFollowingWin(int followingWin) {
		this.followingWin = followingWin;
	}

	@Override
	public String toString() {
		return "WinnerDTO [producer=" + producer + ", interval=" + interval + ", previousWin=" + previousWin
				+ ", followingWin=" + followingWin + "]";
	}

}
