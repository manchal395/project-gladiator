package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

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

}
