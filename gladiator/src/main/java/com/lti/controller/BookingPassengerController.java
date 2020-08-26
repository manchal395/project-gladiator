package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.controller.UsersController.Status;
import com.lti.controller.UsersController.Status.StatusType;
import com.lti.dto.AddBookingDto;
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
