package com.lti.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lti.entity.Passengers;

public class GenerateTicketDto {
	
	private ViewBookingDto booking;

	private List<Passengers> passengers;
	
	public ViewBookingDto getBooking() {
		return booking;
	}
	public void setBooking(ViewBookingDto booking) {
		this.booking = booking;
	}
	public List<Passengers> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passengers> passengers) {
		this.passengers = passengers;
	}

}
