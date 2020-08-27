package com.lti.service;

import java.util.List;

import com.lti.dto.SearchFlightDto;
import com.lti.entity.FlightSchedule;
import com.lti.entity.Flights;
import com.lti.entity.Routes;
import com.lti.entity.Schedule;

public interface SchedulesService {

	void addFlight(Schedule schedule, FlightSchedule flightSchedule);

	Flights isAddFlightPossible(int fid);

	Routes getRoute(String fromCity, String toCity);

	void deleteFlight(int id);

	List<FlightSchedule> isDeleteFlightPossible(int fid);

	List<Object[]> fetchFlightSchedules(SearchFlightDto sfdto, int bs, int es);

}