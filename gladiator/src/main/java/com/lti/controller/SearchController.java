package com.lti.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.FetchedFlightsDto;
import com.lti.dto.SearchFlightDto;
import com.lti.service.SchedulesService;

@RestController
@CrossOrigin
public class SearchController {

	@Autowired
	private SchedulesService schedulesService;
	
	@PostMapping("/searchFlights")
	public List<FetchedFlightsDto> getSearchedFlights(@RequestBody SearchFlightDto sfdto) {
		
		List<FetchedFlightsDto> flightsList = new ArrayList<FetchedFlightsDto>();
		List<Object[]> flights = schedulesService.fetchFlightSchedules(sfdto);
		
		if(sfdto.getArrive()!=null) {
			String temp = sfdto.getSource();
			sfdto.setSource(sfdto.getDestination());
			sfdto.setDestination(temp);
			sfdto.setDepart(sfdto.getArrive());
			flights.addAll(schedulesService.fetchFlightSchedules(sfdto));
		}
		
		FetchedFlightsDto ff;
		for(Object[] obj : flights) {
			ff = new FetchedFlightsDto();
			ff.setAirlines(obj[0].toString());
			ff.setId((int)obj[1]);
			ff.setEconomy((double)obj[2]);
			ff.setBusiness((double)obj[3]);
			ff.setSource(obj[4].toString());
			ff.setDestination(obj[5].toString());
			ff.setDepart((LocalDateTime) obj[6]);
			ff.setArrive((LocalDateTime) obj[7]);		
			flightsList.add(ff);
		}
		return flightsList;
		
	}
	
}
