package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FLIGHTS")
public class Flights {
	
	@Id
	private int id;
	
	private String airlines;
	
	@Column(name = "max_seats")
	private int maxSeats;
	
	@Column(name = "max_baggage_kg")
	private int maxBaggageKg;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public int getMaxSeats() {
		return maxSeats;
	}
	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}
	public int getMaxBaggageKg() {
		return maxBaggageKg;
	}
	public void setMaxBaggageKg(int maxBaggageKg) {
		this.maxBaggageKg = maxBaggageKg;
	}

}
