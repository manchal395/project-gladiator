package com.lti.repository;

import java.util.List;

import com.lti.entity.Booking;
import com.lti.entity.Passengers;

public interface BookingPassengerRepository {

	void addBooking(Booking booking);

	List<Booking> fetchAllBooking();

	void addPassenger(Passengers passenger);

	int fetchBookingScheduleId();

	List<Object[]> viewBooking( int id);

	List<Passengers> fetchAllPassengersByBookingId(int id);

}