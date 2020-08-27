package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.lti.dto.SearchFlightDto;
import com.lti.entity.FlightSchedule;
import com.lti.entity.Flights;
import com.lti.entity.Routes;
import com.lti.entity.Schedule;
import com.lti.entity.Seats;
import com.lti.exception.FetchFlightsException;
import com.lti.repository.FlightsRepository;
import com.lti.repository.RoutesRepository;
import com.lti.repository.SchedulesRepository;
import com.lti.repository.SeatsRepository;

@Service
public class SchedulesServiceImpl implements SchedulesService {

	// addFlight
	// deleteFlight

	@Autowired
	private SchedulesRepository schedulesRepo;

	@Autowired
	private FlightsRepository flightsRepo;

	@Autowired
	private RoutesRepository routesRepo;
	
	@Autowired
	private SeatsRepository seatsRepo;

	@Override
	public Flights isAddFlightPossible(int fid) {
		return flightsRepo.fetchFlightById(fid);
	}

	@Override
	public List<FlightSchedule> isDeleteFlightPossible(int fid) {
		return schedulesRepo.fetchFlightScheduleById(fid);
	}
	
	@Override
	public Routes getRoute(String fromCity, String toCity) {
		return routesRepo.fetchRoute(fromCity, toCity);
	}

	@Override
	@Transactional
	public void addFlight(Schedule schedule, FlightSchedule flightSchedule) {
		// System.out.println("adding schedule...");
		// schedule.setId(1112);
		schedulesRepo.addSchedule(schedule);
		// System.out.println("schedule added, fetching id");
		int sid = schedulesRepo.fetchScheduleId();
		// System.out.println("id fetched");
		schedule.setId(sid);
		// System.out.println("adding flight schedule...");
		flightSchedule.setSchedule(schedule);
		// flightSchedule.setId(203);
		// System.out.println("flight schedule added");
		schedulesRepo.addFlightSchedule(flightSchedule);
		//add seats
		int fsid = schedulesRepo.fetchFlightScheduleId();
		flightSchedule.setId(fsid);
		Seats seat = null;
		for(int i=0; i<flightSchedule.getBusinessSeatsAvailable(); i++) {
			seat = new Seats();
			seat.setFlightSchedule(flightSchedule);
			seat.setClassType("BUSINESS");
			seat.setStatus("AVAILABLE");
			seatsRepo.addSeat(seat);
		}
		for(int i=0; i<flightSchedule.getEconomySeatsAvailable(); i++) {
			seat = new Seats();
			seat.setFlightSchedule(flightSchedule);
			seat.setClassType("ECONOMY");
			seat.setStatus("AVAILABLE");
			seatsRepo.addSeat(seat);
		}
	}
	
	@Override
	@Transactional
	public void deleteFlight(int id) {
		//fetching all schedules for this particular flight id
		List<FlightSchedule> fschedules = schedulesRepo.fetchFlightScheduleById(id);
		//changing status of all those schedules and updating in db
		for(FlightSchedule fs : fschedules) {
			fs.setStatus("UNAVAILABLE");
			schedulesRepo.addFlightSchedule(fs);
		}
	}

	@Override
	public List<Object[]> fetchFlightSchedules(SearchFlightDto sfdto, int bs, int es) {
		try {
			return schedulesRepo.fetchSearchedFlights(sfdto, bs, es);
		}
		catch(DataAccessException e) {
			throw new FetchFlightsException("FLIGHTS NOT FOUND");
		}
	}
	
}
