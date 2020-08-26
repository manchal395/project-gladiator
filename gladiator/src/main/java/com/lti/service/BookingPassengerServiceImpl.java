package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Booking;
import com.lti.entity.Passengers;
import com.lti.repository.BookingRepository;

@Service
public class BookingPassengerServiceImpl implements BookingPassengerService {

	@Autowired
	private BookingRepository bookingRepo;
	
	@Override
	@Transactional
	public void addBooking(Booking booking, Passengers passengers) {
		bookingRepo.addBooking(booking);
		int pnrNo = bookingRepo.fetchPnr();
		booking.setPnr(pnrNo);
		passengers.setBooking(booking);
		bookingRepo.addPassenger(passengers);
		
	}
	
	@Override
	public void addBookingOnly(Booking booking) {
		bookingRepo.addBooking(booking);
	}
	
	
	
	
	
}
