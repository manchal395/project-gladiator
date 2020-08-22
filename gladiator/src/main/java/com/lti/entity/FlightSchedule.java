package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FLIGHT_SCHEDULE")
public class FlightSchedule {
	
	@Id
	//@GeneratedValue
	private int id;
	
	@OneToOne
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;
	
	@ManyToOne
	@JoinColumn(name = "flight_id")
	private Flights flight;
	
	private double economy;
	
	private double business;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Flights getFlight() {
		return flight;
	}

	public void setFlight(Flights flight) {
		this.flight = flight;
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

}
