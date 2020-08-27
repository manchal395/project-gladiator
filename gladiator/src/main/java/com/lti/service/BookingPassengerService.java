package com.lti.service;

import java.util.List;

import com.lti.dto.AddBookingDto;
import com.lti.dto.GenerateTicketDto;

public interface BookingPassengerService {

	void addBookingAndPassengers(AddBookingDto bookingDto, int id);

	List<Object[]> getAllPassengers(int id);

	GenerateTicketDto fetchGeneratedTicket(int userId);

}