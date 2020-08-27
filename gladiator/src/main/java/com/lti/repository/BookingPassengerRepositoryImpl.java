package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.dto.ViewBookingDto;
import com.lti.entity.Booking;
import com.lti.entity.Passengers;

@Repository
public class BookingPassengerRepositoryImpl implements BookingPassengerRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addBooking(Booking booking) {
		entityManager.merge(booking);
	}
	
	@Override
	public void addPassenger(Passengers passenger) {
		entityManager.merge(passenger);
	}
	
	@Override
	public List<Booking> fetchAllBooking() {
		return entityManager.createQuery("SELECT b FROM Booking b").getResultList();
	}
	
	@Override
	public int fetchBookingScheduleId() {
		return (int) entityManager.createQuery("SELECT MAX(b.id) FROM Booking b").getSingleResult();
	}
	
	@Override
	public List<Object[]> viewBooking( int id){
		return entityManager.createQuery("SELECT b.id, b.bookingDateTime,b.totalPassengers, b.bookingAmount, b.status, s.depart, s.arrive, r.source, r.destination FROM Booking b INNER JOIN b.flightSchedule fs INNER JOIN b.flightSchedule.schedule s  INNER JOIN b.flightSchedule.schedule.route r INNER JOIN b.user u WHERE u.id = :id ORDER BY b.bookingDateTime DESC").setParameter("id", id).getResultList();
	}
	
	@Override
	public List<Passengers> fetchAllPassengersByBookingId(int id) {
		return entityManager.createQuery("SELECT p FROM Passengers p WHERE p.booking.id = :id")
				.setParameter("id", id)
				.getResultList();
	}
}
