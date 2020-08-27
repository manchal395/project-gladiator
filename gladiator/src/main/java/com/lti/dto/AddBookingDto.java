package com.lti.dto;

import java.util.List;

public class AddBookingDto {
	
	private int departFlightScheduleId;
	private int returnFlightScheduleId;
	private int userId;
	private int noOfPassengers;
	private List<AddPassengerDto> passengersDetails;
	private double amount;
	private String fclass;
	
	public String getFclass() {
		return fclass;
	}
	public void setFclass(String fclass) {
		this.fclass = fclass;
	}
	public int getDepartFlightScheduleId() {
		return departFlightScheduleId;
	}
	public void setDepartFlightScheduleId(int departFlightScheduleId) {
		this.departFlightScheduleId = departFlightScheduleId;
	}
	public int getReturnFlightScheduleId() {
		return returnFlightScheduleId;
	}
	public void setReturnFlightScheduleId(int returnFlightScheduleId) {
		this.returnFlightScheduleId = returnFlightScheduleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public List<AddPassengerDto> getPassengersDetails() {
		return passengersDetails;
	}
	public void setPassengersDetails(List<AddPassengerDto> passengersDetails) {
		this.passengersDetails = passengersDetails;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
