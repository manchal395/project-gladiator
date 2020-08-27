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
	public Status cancellation(@RequestBody CancelBookingDto cancelBookingDto) {
		try {
		int bookingId=cancelBookingDto.getId();
		cancelBooking.cancelBooking(bookingId);
		Status status = new Status();
		status.setStatus(Status.StatusType.SUCCESS);
		status.setMessage("Cancelled Ticket Successfully!");
		return status;
		}
		catch (Exception e) {
			Status status = new Status();
			status.setStatus(Status.StatusType.FAILURE);
			status.setMessage("Cancellation Failed");
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
