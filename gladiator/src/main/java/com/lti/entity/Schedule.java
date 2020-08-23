package com.lti.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SCHEDULE")
public class Schedule {

	@Id
	@SequenceGenerator(sequenceName = "schedule_seq", allocationSize = 1, name = "seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int id;

	@ManyToOne
	@JoinColumn(name = "route_id")
	private Routes route;

	private LocalDateTime depart;

	private LocalDateTime arrive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Routes getRoute() {
		return route;
	}

	public void setRoute(Routes route) {
		this.route = route;
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
