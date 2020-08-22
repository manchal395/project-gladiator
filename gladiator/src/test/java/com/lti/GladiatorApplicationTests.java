package com.lti;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.entity.Flights;
import com.lti.entity.Routes;
import com.lti.repository.FlightsRepository;
import com.lti.repository.RoutesRepository;

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

}
