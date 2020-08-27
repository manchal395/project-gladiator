package com.lti.controller;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

		Status s = new Status();

		// checking if flight id entered by Admin exists in db or not
		Flights flight = schedulesService.isAddFlightPossible(flightDto.getId());

		if (flight == null) {
			s.setStatus(StatusType.FAILURE);
			s.setMessage("Flight Id does not exist. Enter correct Flight Id");
			return s;
		}

		// getting route id for source and destination entered by admin
		Routes route = schedulesService.getRoute(flightDto.getFromCity(), flightDto.getToCity());

		// creating schedule
		Schedule schedule = new Schedule();
		schedule.setRoute(route);
		BeanUtils.copyProperties(flightDto, schedule);

		FlightSchedule flightSchedule = new FlightSchedule();
		flightSchedule.setFlight(flight);
		int businessSeats = flight.getMaxSeats()/3;
		int economySeats = flight.getMaxSeats() - businessSeats;
		flightSchedule.setBusinessSeatsAvailable(businessSeats);
		flightSchedule.setEconomySeatsAvailable(economySeats);
		
		// change price acc to Weekend
		// Assumption: All airlines have fixed base economy, business price for their
		// respective flights
		double economy = 0;
		double business = 0;

		if (flightDto.getDepart().getDayOfWeek().toString().equals("SATURDAY")
				|| flightDto.getDepart().getDayOfWeek().toString().equals("SUNDAY")) {
			economy = flight.getEconomy() + 500;
			business = flight.getBusiness() + 1000;
		} else {
			economy = flight.getEconomy();
			business = flight.getBusiness();
		}

		// Changing price according to travel hours
		// eg. duration - 8hrs
		// base price from table- first 2 hrs
		// after that, increment 200 for economy, 500 for business

		Duration duration = Duration.between(flightDto.getDepart(), flightDto.getArrive());
		if (duration.toHours() > 2) {
			double d = (duration.toHours() / 2);
			economy += (d * 200);
			business += (d * 500);
		}

		flightSchedule.setEconomy(economy);
		flightSchedule.setBusiness(business);

		schedulesService.addFlight(schedule, flightSchedule);

		s.setStatus(StatusType.SUCCESS);
		s.setMessage("Flight Schedule Added Successfully");
		return s;

	}

	@PostMapping("/deleteFlight")
	public Status deleteFlight(@RequestBody Integer id) {
		Status s = new Status();
		//System.out.println(id);
		
		List<FlightSchedule> list = schedulesService.isDeleteFlightPossible((int) id);

		if (list.isEmpty()) {
			s.setStatus(StatusType.FAILURE);
			s.setMessage("Flight Id does not exist. Enter correct Flight Id");
			return s;
		}
		
		schedulesService.deleteFlight((int)id);
		s.setStatus(StatusType.SUCCESS);
		s.setMessage("Flight Status Changed Successfully");
		return s;
		
		
	}
	
	public static class Status {

		private StatusType status;
		private String message;

		public static enum StatusType {
			SUCCESS, FAILURE;
		}

		public void setStatus(StatusType status) {
			this.status = status;
		}

		public StatusType getStatus() {
			return status;
		}

		public String getMessage() {
			return this.message;
		}

		public void setMessage(String msg) {
			this.message = msg;
		}

	}

}
