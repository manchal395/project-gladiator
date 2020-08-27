package com.lti.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AddBookingDto;
import com.lti.dto.ViewBookingDto;
import com.lti.dto.ViewUserDto;
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
	
	@PostMapping("/viewBooking")
	public List<ViewBookingDto> viewBooking(@RequestBody ViewUserDto viewUserDto) {
		List<ViewBookingDto> allPassenger= new ArrayList<ViewBookingDto>();
		int id= viewUserDto.getUserId();
		List<Object[]> passengers=bpService.getAllPassengers(id);
		ViewBookingDto viewBookDt;
		for(Object[] obj : passengers) {
			viewBookDt=new ViewBookingDto();
			viewBookDt.setId((int)obj[0]);
			viewBookDt.setBookingDateTime((LocalDateTime)obj[1]);
			viewBookDt.setTotalPassengers((int) obj[2]);
			viewBookDt.setBookingAmount((double)obj[3]);
			viewBookDt.setStatus((String)obj[4]);
			viewBookDt.setDepart((LocalDateTime)obj[5]);
			viewBookDt.setArrive((LocalDateTime)obj[6]);
			viewBookDt.setSource((String)obj[7]);
			viewBookDt.setDestination((String)obj[8]);
			allPassenger.add(viewBookDt);
		}
		return allPassenger;
	}
	
	

}
