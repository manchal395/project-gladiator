package com.lti;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.dto.SearchFlightDto;
import com.lti.entity.Flights;
import com.lti.entity.Routes;
import com.lti.repository.FlightsRepository;
import com.lti.repository.RoutesRepository;
import com.lti.repository.SchedulesRepository;

/* TODO
 * 1. why Rollback?
 * 2. add asserts
 */

@SpringBootTest

@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class GladiatorApplicationTests {

	@Autowired
	private FlightsRepository flightsRepo;
	
	@Autowired
	private RoutesRepository routesRepo;
	
	@Autowired
	private SchedulesRepository schedulesRepo;
	
//	@Test
//	void addFlight() {
//		Flights flight = new Flights();
//		flight.setId(5);
//		flight.setAirlines("Go Air");
//		flight.setMaxSeats(60);
//		flight.setMaxBaggageKg(17);
//		
//		flightsRepo.addFlight(flight);
//	}
	
	@Test
	void fetchFlight() {
		Flights flight = flightsRepo.fetchFlightById(002);
		System.out.println(flight.getAirlines()+" "+flight.getId()+" "+flight.getMaxSeats()+" "+flight.getMaxBaggageKg());
	}
	
//	@Test
//	void addRoute() {
//		Routes route = new Routes();
//		route.setId(107);
//		route.setSource("Pune");
//		route.setDestination("Chennai");
//		
//		routesRepo.addRoute(route);
//		
//		route = new Routes();
//		route.setId(108);
//		route.setSource("Chennai");
//		route.setDestination("Pune");
//		
//		routesRepo.addRoute(route);
//	}
	
	@Test
	void fetchRoute() {
		Routes route = routesRepo.fetchRouteById(103);
		System.out.println(route.getId()+" "+route.getSource()+" "+route.getDestination());
	}
	
	@Test
	void fetchSearchedFlights() {
//		SearchFlightDto s = new SearchFlightDto();
//		s.setSource("Delhi");
//		s.setDestination("Pune");
//		s.setDepart(LocalDate.of(2020, 8, 25));
//		//System.out.println("Date: " + s.getDepart().toString());
//		List<Object[]> list = schedulesRepo.fetchSearchedFlights(s);
//		for(Object[] o : list)
//			System.out.println(o[0]+" "+o[1]+" "+o[2]+" "+o[3]+" "+o[4]+" "+o[5]+" "+o[6]+" "+o[7]);
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		System.out.println("Date: " +s.getDepart().format(format).toString());
		
	}

}
