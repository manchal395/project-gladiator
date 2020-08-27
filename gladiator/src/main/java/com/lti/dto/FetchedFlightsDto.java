package com.lti.dto;

import java.time.LocalDateTime;

public class FetchedFlightsDto {
	
	private String airlines;
	private int id;
	private int fsId;
	private double economy;
	private double business;
	private String source;
	private String destination;
	private LocalDateTime depart;
	private LocalDateTime arrive;
	
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getEconomy() {
		return economy;
	}
	public void setEconomy(double economy) {
		this.economy = economy;
	}
	public double getBusiness() {
		return business;
	}
	public void setBusiness(double business) {
		this.business = business;
	}
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
	public LocalDateTime getDepart() {
		return depart;
	}
	public void setDepart(LocalDateTime depart) {
		this.depart = depart;
	}
	public LocalDateTime getArrive() {
		return arrive;
	}
	public void setArrive(LocalDateTime arrive) {
		this.arrive = arrive;
	}
	public int getFsId() {
		return fsId;
	}
	public void setFsId(int fsId) {
		this.fsId = fsId;
	}
	
}
