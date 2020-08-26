package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Seats;

@Repository
public class SeatsRepositoryImpl implements SeatsRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addSeat(Seats seat) {
		entityManager.merge(seat);
	}

	//seat will depend on
	//1. flight schedule id
	//2. seat class
	//3. status - available
	
	@Override
	public Seats fetchSeat(int fsId, String fclass) {
		return (Seats) entityManager.createQuery("SELECT seat FROM Seats seat WHERE seat.id = "
				+ "(SELECT MIN(s.id) FROM Seats s WHERE "
				+ "s.flightSchedule.id = :fsId AND s.classType = :fclass AND s.status = :s)")
				.setParameter("fsId", fsId)
				.setParameter("fclass", fclass)
				.setParameter("s", "AVAILABLE")
				.getSingleResult();
	}
	
	@Override
	public void changeSeatStatus(Seats seat) {
		seat.setStatus("BOOKED");
		entityManager.merge(seat);
	}
	
}
