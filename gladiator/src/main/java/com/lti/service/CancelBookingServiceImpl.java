package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Booking;
import com.lti.entity.FlightSchedule;
import com.lti.entity.Passengers;
import com.lti.entity.Seats;
import com.lti.exception.UsersServiceException;
import com.lti.repository.BookingPassengerRepository;
import com.lti.repository.CancelBookingRepository;
import com.lti.repository.SchedulesRepository;
import com.lti.repository.SeatsRepository;

@Service
public class CancelBookingServiceImpl implements CancelBookingService {
	@Autowired
	private CancelBookingRepository cancelRepo;

	@Autowired
	private SeatsRepository seatRepo;

	@Autowired
	private SchedulesRepository scheduleRepo;

	@Autowired
	private BookingPassengerRepository bookingPassengerRepo;

	@Override
	@Transactional
	public void cancelBooking(int bookingId) {
		try {

			List<Seats> allSeats = cancelRepo.fetchBookkedSeatsByBookedId(bookingId);
			Booking booking = cancelRepo.fetchBookingById(bookingId);

			int flightScheduleId = booking.getFlightSchedule().getId();
			FlightSchedule fs = cancelRepo.fetchFlightSchedule(flightScheduleId);
			String classOfSeat = allSeats.get(0).getClassType();
			int totalPassengerOnBookingId = booking.getTotalPassengers();
			for (int i = 0; i < booking.getTotalPassengers(); i++) {
				String status = allSeats.get(i).getStatus();
				if (status.equalsIgnoreCase("BOOKED")) {
					allSeats.get(i).setStatus("AVAILABLE");
					seatRepo.addSeat(allSeats.get(i));
				}
			}
			if (classOfSeat.equalsIgnoreCase("ECONOMY")) {
				int temp = fs.getEconomySeatsAvailable();
				fs.setEconomySeatsAvailable(temp + totalPassengerOnBookingId);
				scheduleRepo.addFlightSchedule(fs);

			} else {
				int temp = fs.getBusinessSeatsAvailable();
				fs.setBusinessSeatsAvailable(temp + totalPassengerOnBookingId);
				scheduleRepo.addFlightSchedule(fs);
			}
			if (booking.getStatus().equalsIgnoreCase("CONFIRMED")) {
				booking.setStatus("CANCELLED");
				bookingPassengerRepo.addBooking(booking);
			}
			List<Passengers> passengers=cancelRepo.fetchAllPassengersByBookingId(bookingId);
			Seats st=null;
			for (int i = 0; i < booking.getTotalPassengers(); i++) {
				if(passengers.get(i) !=null) {
					passengers.get(i).setSeat(st);
					bookingPassengerRepo.addPassenger(passengers.get(i));
				}
			}
			
		} catch (EmptyResultDataAccessException e) {
			throw new UsersServiceException("Please Enter Correct Booking ID");
		}
	}

}
