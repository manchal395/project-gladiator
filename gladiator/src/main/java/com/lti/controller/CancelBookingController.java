package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CancelBookingDto;
import com.lti.service.CancelBookingService;

@RestController
@CrossOrigin
public class CancelBookingController {
	@Autowired
	private CancelBookingService cancelBooking;
	
	@PostMapping("/cancelBooking")
	public void cancellation(@RequestBody CancelBookingDto cancelBookingDto) {
		int bookingId=cancelBookingDto.getId();
		cancelBooking.cancelBooking(bookingId);
	}
	
}
