package com.lti.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AddPassengerDto;
import com.lti.entity.Booking;
import com.lti.entity.Passengers;
import com.lti.service.BookingPassengerService;

@RestController
@CrossOrigin
public class PassengerBookingController {
	
	@Autowired
	private BookingPassengerService bPService;
	
	@PostMapping("/addBooking")
	public void addBooking(@RequestBody AddPassengerDto addPassengerDto) {
		
//		addPassengerDto.setUserId();
//		Status status = new Status();
//		
		Booking bkg = new Booking();
//		bkg.getPnr();
		bkg.setUserId(addPassengerDto.getUserId());
		bkg.setFlightScheduleId(addPassengerDto.getFlightScheduleId());
		bkg.setBookingDate(addPassengerDto.getBookingDate());
		bkg.setTotalPassengers(addPassengerDto.getTotalPassengers());
	

		bPService.addBookingOnly(bkg);
		
		Passengers psg = new Passengers();
		psg.setTitle(addPassengerDto.getTitle());
		psg.setFullName(addPassengerDto.getFullName());
		psg.setAge(addPassengerDto.getAge());
		psg.setGender(addPassengerDto.getGender());
		psg.setPhoneNumber(addPassengerDto.getPhoneNumber());
		
		System.out.println("Added a Record!");
		
//		bPService.addBooking(booking, passengers);
//		Passengers passengers = new Passengers();	
//		List<Passengers> psg = new List<Passengers>();
		
	}
	
	

}
