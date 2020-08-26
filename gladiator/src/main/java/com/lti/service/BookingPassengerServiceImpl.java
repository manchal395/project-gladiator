package com.lti.service;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.AddBookingDto;
import com.lti.entity.Booking;
import com.lti.entity.FlightSchedule;
import com.lti.entity.Passengers;
import com.lti.entity.Users;
import com.lti.exception.BookingServiceException;
import com.lti.repository.BookingPassengerRepository;
import com.lti.repository.SchedulesRepository;
import com.lti.repository.SeatsRepository;
import com.lti.repository.UsersRepository;
@Service
public class BookingPassengerServiceImpl implements BookingPassengerService {

	@Autowired
	private BookingPassengerRepository bookingRepo;
	
	@Autowired
	private SchedulesRepository schedulesRepo;
	
	@Autowired
	private UsersRepository userRepo;
	
	@Autowired
	private SeatsRepository seatsRepo;
	
	@Override
	@Transactional
	public void addBookingAndPassengers(AddBookingDto bookingDto, int id) {
		try {
		Booking booking = new Booking();
		FlightSchedule fs = schedulesRepo.fetchSingleFlightScheduleById(id);
		Users user = userRepo.fetchUserById(bookingDto.getUserId());
		booking.setFlightSchedule(fs);
		booking.setUser(user);
		booking.setBookingDateTime(LocalDateTime.now());
		booking.setTotalPassengers(bookingDto.getNoOfPassengers());
		booking.setBookingAmount(bookingDto.getAmount());
		booking.setStatus("CONFIRMED");
		
		bookingRepo.addBooking(booking);
		
		int bid = bookingRepo.fetchBookingScheduleId();
		booking.setId(bid);
		
		Passengers passenger = null;
		
		for(int i=0; i<bookingDto.getNoOfPassengers(); i++) {
			passenger = new Passengers();
			
			BeanUtils.copyProperties(bookingDto.getPassengersDetails().get(i), passenger);
			passenger.setBooking(booking);
			
			//seat will depend on
			//1. flight schedule id
			//2. seat class
			//3. status - available
			passenger.setSeat(seatsRepo.fetchSeat(fs.getId(), bookingDto.getFclass()));
			
			//change this seat's status
			seatsRepo.changeSeatStatus(passenger.getSeat());
			bookingRepo.addPassenger(passenger);
		}
		
		if(bookingDto.getFclass().equalsIgnoreCase("BUSINESS"))
			fs.setBusinessSeatsAvailable(fs.getBusinessSeatsAvailable() - bookingDto.getNoOfPassengers());
		else
			fs.setEconomySeatsAvailable(fs.getEconomySeatsAvailable() - bookingDto.getNoOfPassengers());
		}
		catch(Exception e) {
			throw new BookingServiceException("Booking Failed!");
		}
		
	}
	
	
}
