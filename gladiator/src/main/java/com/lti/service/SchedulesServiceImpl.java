package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.FlightSchedule;
import com.lti.entity.Flights;
import com.lti.entity.Routes;
import com.lti.entity.Schedule;
import com.lti.repository.FlightsRepository;
import com.lti.repository.RoutesRepository;
import com.lti.repository.SchedulesRepository;

@Service
public class SchedulesServiceImpl implements SchedulesService {
	
	//addFlight
	//deleteFlight
	
	@Autowired
	private SchedulesRepository schedulesRepo;
	
	@Autowired
	private FlightsRepository flightsRepo;
	
	@Autowired
	private RoutesRepository routesRepo;
	
	@Override
	public Flights isAddFlightPossible(int fid) {
		return flightsRepo.fetchFlightById(fid);
	}
	
	@Override
	public Routes getRoute(String fromCity, String toCity) {
		return routesRepo.fetchRoute(fromCity, toCity);
	}
	
	@Override
	public void addFlight(Schedule schedule, FlightSchedule flightSchedule) {
		System.out.println("adding schedule...");
		schedule.setId(1111);
		schedulesRepo.addSchedule(schedule);
		System.out.println("schedule added, fetching id");
		int sid = schedulesRepo.fetchScheduleId();
		System.out.println("id fetched");
		schedule.setId(sid);
		System.out.println("adding flight schedule...");
		flightSchedule.setSchedule(schedule);
		flightSchedule.setId(202);
		System.out.println("flight schedule added");
		schedulesRepo.addFlightSchedule(flightSchedule);
		
	}

}
