package com.lti.service;

import com.lti.entity.Booking;
import com.lti.entity.Passengers;

public interface BookingPassengerService {

	void addBooking(Booking booking, Passengers passengers);

	void addBookingOnly(Booking booking);

}