package com.lti.service;

import com.lti.dto.AddBookingDto;

public interface BookingPassengerService {

	void addBookingAndPassengers(AddBookingDto bookingDto, int id);

}