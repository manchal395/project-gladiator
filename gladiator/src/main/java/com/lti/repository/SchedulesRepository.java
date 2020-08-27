package com.lti.repository;

import java.util.List;

import com.lti.dto.SearchFlightDto;
import com.lti.entity.FlightSchedule;
import com.lti.entity.Schedule;

public interface SchedulesRepository {

	void addSchedule(Schedule schedule);

	void addFlightSchedule(FlightSchedule flightSchedule);

	List<Schedule> fetchAllSchedules();

	List<FlightSchedule> fetchAllFlightSchedules();

	int fetchScheduleId();

	List<FlightSchedule> fetchFlightScheduleById(int id);

	int fetchFlightScheduleId();

	List<Object[]> fetchSearchedFlights(SearchFlightDto sfdto, int bs, int es);

	FlightSchedule fetchSingleFlightScheduleById(int id);

}