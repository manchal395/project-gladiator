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
@Table(name="PASSENGERS")
public class Passengers {
	
	@Id
	@SequenceGenerator(sequenceName = "passenger_seq", allocationSize = 1, name = "REX")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REX")
	private int id;
	
	private String title;
	
	@Column(name="full_name")
	private String fullName;
	
	private String gender;
	
	private int age;
	
	@Column(name="phone_number")
	private long phoneNumber;
	
	@OneToOne
	@JoinColumn(name="seat_number")
	private Seats seat;
	
	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Seats getSeat() {
		return seat;
	}

	public void setSeat(Seats seat) {
		this.seat = seat;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
