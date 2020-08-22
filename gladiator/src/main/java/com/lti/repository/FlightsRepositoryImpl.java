package com.lti.repository;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Flights;

@Repository
public class FlightsRepositoryImpl implements FlightsRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public Flights fetchFlightById(int id) {
		return entityManager.find(Flights.class, id);
	}
	
	@Override
	public List<Flights> fetchAllFlights() {
		return entityManager.createQuery("SELECT f FROM Flights f").getResultList();
	}

	@Override
	public boolean isFlight(int id) {
		return (Long) 
				entityManager.createQuery("SELECT COUNT(f.id) FROM Flights f WHERE f.id = :id")
				.setParameter("id", id)
				.getSingleResult() == 1 ? true : false;
	}
	
}
