package com.lti.dto;

import java.time.LocalDate;

public class SearchFlightDto {

	private String source;	
	private String destination;
	private LocalDate depart;
	private LocalDate arrive;
	private int noOfPassengers;
	private String fclass;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getDepart() {
		return depart;
	}
	public void setDepart(LocalDate depart) {
		this.depart = depart;
	}
	public LocalDate getArrive() {
		return arrive;
	}
	public void setArrive(LocalDate arrive) {
		this.arrive = arrive;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public String getFclass() {
		return fclass;
	}
	public void setFclass(String fclass) {
		this.fclass = fclass;
	}
	
}
