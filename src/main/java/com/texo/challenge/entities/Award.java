package com.texo.challenge.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity(name = "award")
@Table(name = "award")
public class Award {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToMany
	@JoinTable(name = "award_producer", joinColumns = @JoinColumn(name = "award_id"), inverseJoinColumns = @JoinColumn(name = "producer_id"))
	private List<Producer> producers;

	@ManyToMany
	@JoinTable(name = "award_studio", joinColumns = @JoinColumn(name = "award_id"), inverseJoinColumns = @JoinColumn(name = "studio_id"))
	private List<Studio> studios;

	@Column(name = "year_award")
	private int year;

	@Column(name = "title")
	private String title;
	@Column(name = "winner")
	private boolean winner;

	public Award() {
	}

	public Award(Long id, List<Producer> producers, List<Studio> studios, int year, String title, boolean winner) {
		this.id = id;
		this.producers = producers;
		this.studios = studios;
		this.year = year;
		this.title = title;
		this.winner = winner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Producer> getProducers() {
		return producers;
	}

	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}

	public List<Studio> getStudios() {
		return studios;
	}

	public void setStudios(List<Studio> studios) {
		this.studios = studios;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "Award [id=" + id + ", producer=" + producers + ", studio=" + studios + ", year=" + year + ", title="
				+ title + ", winner=" + winner + "]";
	}

}
