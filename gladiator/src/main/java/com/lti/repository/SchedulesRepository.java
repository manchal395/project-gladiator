package com.lti.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.lti.entity.FlightSchedule;
import com.lti.entity.Schedule;

public interface SchedulesRepository {

	void addSchedule(Schedule schedule);

	void addFlightSchedule(FlightSchedule flightSchedule);

	List<Schedule> fetchAllSchedules();

	List<FlightSchedule> fetchAllFlightSchedules();

	int fetchScheduleId();

}