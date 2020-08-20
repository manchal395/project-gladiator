package com.lti.repository;

import java.util.List;

import com.lti.entity.Flights;
import com.lti.entity.Routes;

public interface FlightsRepository {

	void addFlight(Flights flight);

	Flights fetchFlightById(int id);
	
	List<Flights> fetchAllFlights();
	
}