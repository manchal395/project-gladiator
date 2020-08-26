package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="passengers")
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
	private int phoneNumber;
	
	@Column(name="seat_number")
	private int seatNo;
	
	@ManyToOne
	@JoinColumn(name = "pnr", referencedColumnName = "pnr")
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


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}


	public Booking getBooking() {
		return booking;
	}


	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
}
