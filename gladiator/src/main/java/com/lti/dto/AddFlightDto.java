package com.lti.dto;

import java.time.LocalDateTime;

public class AddFlightDto {
	
	//we need to check if this flight exists, from and to city exists
	//or we can just show all the flight ids and routes in dropdown to admin
	
	private int id;	
	private String fromCity;
	private String toCity;
	//on basis of from and to city, get a route id from routes table (jpql)
	private LocalDateTime depart;
	private LocalDateTime arrive;
	
	
	
	/* controller should first call a service that
	 * should first check if a flight exists or not! 
	 * if exists, this service should return a route id
	 * 
	 * controller will map the dto object to schedule and flight schedule object
	 * 
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
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

}
