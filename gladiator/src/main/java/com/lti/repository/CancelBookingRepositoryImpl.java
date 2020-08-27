package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Booking;
import com.lti.entity.FlightSchedule;
import com.lti.entity.Passengers;
import com.lti.entity.Seats;


@Repository
public class CancelBookingRepositoryImpl implements CancelBookingRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Booking fetchBookingById(int id) {
		return (Booking) entityManager.createQuery("SELECT b FROM Booking b where b.id = :id").setParameter("id",id).getSingleResult();
		//return entityManager.find(Booking.class, id);
	}
	@Override
	public List<Seats> fetchBookkedSeatsByBookedId(int id) {
		return   entityManager.createQuery("SELECT p.seat from Passengers p where p.booking.id= :id").setParameter("id",id).getResultList();
	}
	@Override
	public FlightSchedule fetchFlightSchedule(int id) {
		return (FlightSchedule) entityManager.createQuery("SELECT f FROM FlightSchedule f where f.id = :id").setParameter("id",id).getSingleResult();
	}
	
	@Override
	public List<Passengers> fetchAllPassengersByBookingId(int id){
		return entityManager.createQuery("SELECT p from Passengers p where p.booking.id= :id").setParameter("id",id).getResultList();
	}

}
