package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AddBookingDto;
import com.lti.service.BookingPassengerService;

@RestController
@CrossOrigin
public class BookingPassengerController {
	
	@Autowired
	private BookingPassengerService bpService;
	
	
	@PostMapping("/bookFlight")
	public void addBooking(@RequestBody AddBookingDto addBookingDto) {
		
		//depart
		bpService.addBookingAndPassengers(addBookingDto, addBookingDto.getDepartFlightScheduleId());
		
		if(addBookingDto.getReturnFlightScheduleId() != 0)
			bpService.addBookingAndPassengers(addBookingDto, addBookingDto.getReturnFlightScheduleId());
		
	}
	
	

}
