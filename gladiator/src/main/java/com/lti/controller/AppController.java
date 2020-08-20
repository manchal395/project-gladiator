package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Flights;
import com.lti.entity.Routes;
import com.lti.repository.FlightsRepository;
import com.lti.repository.RoutesRepository;

@RestController
@CrossOrigin
public class AppController {

	//should Autowire Service class object
	
	@Autowired
	private FlightsRepository flightsRepo;
	
	@Autowired
	private RoutesRepository routesRepo;
	
	@GetMapping("/flights")
	public List<Flights> getFlights() {
		return flightsRepo.fetchAllFlights();
	}
	
	@GetMapping("/routes")
	public List<Routes> getRoutes() {
		return routesRepo.fetchAllRoutes();
	}
	
	@PostMapping("/addFlight")
	public String addFlight(@RequestBody Flights flight) {
		flightsRepo.addFlight(flight);
		return "Record Added Successfully";
	}
	
	@PostMapping("/addRoute")
	public String addRoute(@RequestBody Routes route) {
		routesRepo.addRoute(route);
		return "Record Added Successfully";
	}
	
}
