package com.lti.repository;

import java.util.List;

import com.lti.entity.Booking;
import com.lti.entity.FlightSchedule;
import com.lti.entity.Passengers;
import com.lti.entity.Seats;

public interface CancelBookingRepository {

	Booking fetchBookingById(int id);

	List<Seats> fetchBookkedSeatsByBookedId(int id);

	FlightSchedule fetchFlightSchedule(int id);

	List<Passengers> fetchAllPassengersByBookingId(int id);

}