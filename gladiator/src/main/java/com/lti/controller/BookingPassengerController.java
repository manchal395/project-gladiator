package com.lti.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lti.controller.UsersController.Status;
import com.lti.controller.UsersController.Status.StatusType;
import com.lti.dto.AddBookingDto;
import com.lti.dto.GenerateTicketDto;
import com.lti.dto.ViewBookingDto;
import com.lti.dto.ViewUserDto;
import com.lti.exception.BookingServiceException;
import com.lti.service.BookingPassengerService;

@RestController
@CrossOrigin
public class BookingPassengerController {
	
	@Autowired
	private BookingPassengerService bpService;
	
	
	@PostMapping("/bookFlight")
	public Status addBooking(@RequestBody AddBookingDto addBookingDto) {
		
		//depart
		try {
			bpService.addBookingAndPassengers(addBookingDto, addBookingDto.getDepartFlightScheduleId());
			
			if(addBookingDto.getReturnFlightScheduleId() != 0)
				bpService.addBookingAndPassengers(addBookingDto, addBookingDto.getReturnFlightScheduleId());
			Status status = new Status();
			status.setStatus(Status.StatusType.SUCCESS);
			status.setMessage("Booking Successful!");
			return status;
		
		}
		catch(BookingServiceException b) {
			Status status = new Status();
			status.setStatus(Status.StatusType.FAILURE);
			status.setMessage(b.getMessage());
			return status;
		}
		
		
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

	@PostMapping(path = "/viewTicket", consumes = "application/json", produces = "application/json")
	public GenerateTicketDto generateTicket(@RequestBody ViewUserDto viewUserDto) {
		
		GenerateTicketDto ticket = bpService.fetchGeneratedTicket(viewUserDto.getUserId());
		return ticket;
		
	}

	public static class Status {
		private StatusType status;
		private String message;
		
		
		public static enum StatusType{
			SUCCESS, FAILURE;
		}

		public StatusType getStatus() {
			return status;
		}

		public void setStatus(StatusType status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
	}
		

}
