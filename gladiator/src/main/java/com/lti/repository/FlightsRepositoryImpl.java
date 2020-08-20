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
	@Transactional
	public void addFlight(Flights flight) {
		entityManager.merge(flight);
	}
	
	@Override
	public Flights fetchFlightById(int id) {
		return entityManager.find(Flights.class, id);
	}
	
	@Override
	public List<Flights> fetchAllFlights() {
		return entityManager.createQuery("SELECT f FROM Flights f").getResultList();
	}

}
