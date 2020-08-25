package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Passengers;

@Repository
public class PassengersRepositoryImpl implements PassengersRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	@Override
	public List<Passengers> fetchPassengerByPnr(int pnr){
		return entityManager.createQuery("SELECT p FROM Passengers p WHERE p.pnr = :pnr").setParameter("pnr", pnr).getResultList();
	}
	

}
