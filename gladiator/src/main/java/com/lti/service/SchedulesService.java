package com.lti.service;

import com.lti.entity.FlightSchedule;
import com.lti.entity.Flights;
import com.lti.entity.Routes;
import com.lti.entity.Schedule;

public interface SchedulesService {

	void addFlight(Schedule schedule, FlightSchedule flightSchedule);

	Flights isAddFlightPossible(int fid);

	Routes getRoute(String fromCity, String toCity);

}