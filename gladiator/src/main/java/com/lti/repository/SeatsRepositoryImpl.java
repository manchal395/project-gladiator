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

}
