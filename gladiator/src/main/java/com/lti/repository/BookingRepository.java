package com.lti.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Booking;
import com.lti.entity.Passengers;

public interface BookingRepository {

	void addBooking(Booking booking);

	List<Booking> fetchAllBooking();

	int fetchPnr();

	void addPassenger(Passengers passenger);

}