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
import com.lti.exception.FetchFlightsException;
import com.lti.service.SchedulesService;

@RestController
@CrossOrigin
public class SearchController {

	@Autowired
	private SchedulesService schedulesService;
	
	@PostMapping("/searchFlights")
	public List<FetchedFlightsDto> getSearchedFlights(@RequestBody SearchFlightDto sfdto) {

		try {

			List<FetchedFlightsDto> flightsList = new ArrayList<FetchedFlightsDto>();
			int bs = 0, es = 0;
			if (sfdto.getFclass().equalsIgnoreCase("Business"))
				bs = sfdto.getNoOfPassengers();
			else
				es = sfdto.getNoOfPassengers();
			List<Object[]> flights = schedulesService.fetchFlightSchedules(sfdto, bs, es);

			if (sfdto.getArrive() != null) {
				String temp = sfdto.getSource();
				sfdto.setSource(sfdto.getDestination());
				sfdto.setDestination(temp);
				sfdto.setDepart(sfdto.getArrive());
				flights.addAll(schedulesService.fetchFlightSchedules(sfdto, bs, es));
			}

			FetchedFlightsDto ff;
			for (Object[] obj : flights) {
				ff = new FetchedFlightsDto();
				ff.setAirlines(obj[0].toString());
				ff.setId((int) obj[1]);
				ff.setFsId((int) obj[2]);
				ff.setEconomy((double) obj[3]);
				ff.setBusiness((double) obj[4]);
				ff.setSource(obj[5].toString());
				ff.setDestination(obj[6].toString());
				ff.setDepart((LocalDateTime) obj[7]);
				ff.setArrive((LocalDateTime) obj[8]);
				flightsList.add(ff);
			}
			return flightsList;
		} catch (FetchFlightsException f) {
			return null;
		}

	}
	
}
