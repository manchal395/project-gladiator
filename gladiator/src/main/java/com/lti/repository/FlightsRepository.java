package com.lti.repository;

import java.util.List;

import com.lti.entity.Flights;
import com.lti.entity.Routes;

public interface FlightsRepository {

	Flights fetchFlightById(int id);
	
	List<Flights> fetchAllFlights();

	boolean isFlight(int id);
	
}