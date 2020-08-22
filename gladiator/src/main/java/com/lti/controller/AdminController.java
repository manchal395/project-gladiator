package com.lti.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.controller.AdminController.Status.StatusType;
import com.lti.dto.AddFlightDto;
import com.lti.entity.FlightSchedule;
import com.lti.entity.Flights;
import com.lti.entity.Routes;
import com.lti.entity.Schedule;
import com.lti.service.SchedulesService;


@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private SchedulesService schedulesService;
	
	@PostMapping("/addFlight")
	public Status addFlight(@RequestBody AddFlightDto flightDto) {
		
		//System.out.println(flightDto.get);
		
		Status s = null;
		
		Flights flight = schedulesService.isAddFlightPossible(flightDto.getId());
		
		//if idStatus = -1, tell admin that flight id is wronng and return
		//if idStatus != -1, then continue
		
		if(flight == null) {
			s.setStatus(StatusType.FAILURE);
			s.setMessage("Flight Id does not exist. Enter correct Flight Id");
			return s;
		}
		
		Routes route = schedulesService.getRoute(flightDto.getFromCity(), flightDto.getToCity());
		
		Schedule schedule = new Schedule();
		schedule.setRoute(route);
		BeanUtils.copyProperties(flightDto, schedule);
		
		FlightSchedule flightSchedule = new FlightSchedule();
		
		//TODO: set price acc to Weekend
		flightSchedule.setFlight(flight);
		flightSchedule.setEconomy(1500);
		flightSchedule.setBusiness(2000);
		
		schedulesService.addFlight(schedule, flightSchedule);
		s.setStatus(StatusType.SUCCESS);
		s.setMessage("Flight Schedule Added Successfully");
		return s;
		
	}
	
	public static class Status {
		
		private StatusType status;
		private String message;
		
		public static enum StatusType {
			SUCCESS, FAILURE;
		}
		
		public StatusType getStatus() {
			return status;
		}
		
		public void setStatus(StatusType status) {
			this.status = status;
		}
		
		public String getMessage() {
			return this.message;
		}
		
		public void setMessage(String msg) {
			this.message = msg;
		}
		
	}
	
	
}
