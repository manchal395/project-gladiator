package com.lti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FLIGHT_SCHEDULE")
public class FlightSchedule {

	@Id
	@SequenceGenerator(sequenceName = "fschedule_seq", allocationSize = 1, name = "seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int id;

	@OneToOne
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	@ManyToOne
	@JoinColumn(name = "flight_id")
	private Flights flight;

	private double economy;

	private double business;
	
	private String status = "AVAILABLE";
	
	@Column(name = "eco_seats_available")
	private int economySeatsAvailable;
	
	@Column(name = "bus_seats_available")
	private int businessSeatsAvailable;
	
	@OneToMany(mappedBy = "flightSchedule")
	private List<Seats> seats;
	
	@OneToMany(mappedBy = "flightSchedule")
	private List<Booking> bookings;

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEconomySeatsAvailable() {
		return economySeatsAvailable;
	}

	public void setEconomySeatsAvailable(int economySeatsAvailable) {
		this.economySeatsAvailable = economySeatsAvailable;
	}

	public int getBusinessSeatsAvailable() {
		return businessSeatsAvailable;
	}

	public void setBusinessSeatsAvailable(int businessSeatsAvailable) {
		this.businessSeatsAvailable = businessSeatsAvailable;
	}

	public List<Seats> getSeats() {
		return seats;
	}

	public void setSeats(List<Seats> seats) {
		this.seats = seats;
	}

}
