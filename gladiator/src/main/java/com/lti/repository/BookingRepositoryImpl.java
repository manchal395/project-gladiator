package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Booking;
import com.lti.entity.Passengers;

@Repository
public class BookingRepositoryImpl implements BookingRepository {
	
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
	public int fetchPnr() {
		return (int)entityManager.createQuery("select max(b.pnr) from booking b").getSingleResult();
	}
	
	

}
