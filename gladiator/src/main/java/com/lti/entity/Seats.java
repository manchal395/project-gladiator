package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SEATS")
public class Seats {

	@Id
	@SequenceGenerator(sequenceName = "seats_seq", allocationSize = 1, name = "seqS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqS")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "fs_id")
	private FlightSchedule flightSchedule;
	
	private String status;
	
	@Column(name = "class")
	private String classType;
	
	@OneToOne(mappedBy = "seat")
	private Passengers passenger;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Passengers getPassenger() {
		return passenger;
	}

	public void setPassenger(Passengers passenger) {
		this.passenger = passenger;
	}
	
}
