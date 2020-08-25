package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@SequenceGenerator(sequenceName = "booking_seq", allocationSize = 1, name = "seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="flight_schedule_id")
	private int flightScheduleId;
	
	@Column(name="booking_date")
	private LocalDate bookingDate;
	
	@SequenceGenerator(sequenceName = "pnr_seq", allocationSize = 1, name = "per")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "per")// doubt: how to generate pnr automatically // idea: creating a static variable globally.
	private int pnr;

	@Column(name="total_passengers")
	private int totalPassengers;
	
	@Column(name="transaction_id")
	private int transactionId;

	@OneToMany(mappedBy="booking")
	private List<Passengers> passengers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFlightScheduleId() {
		return flightScheduleId;
	}

	public void setFlightScheduleId(int flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public int getTotalPassengers() {
		return totalPassengers;
	}

	public void setTotalPassengers(int totalPassengers) {
		this.totalPassengers = totalPassengers;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public List<Passengers> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passengers> passengers) {
		this.passengers = passengers;
	}

}
