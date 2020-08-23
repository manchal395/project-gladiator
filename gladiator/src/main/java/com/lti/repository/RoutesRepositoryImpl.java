package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Routes;

@Repository
public class RoutesRepositoryImpl implements RoutesRepository {

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public Routes fetchRouteById(int id) {
		return entityManager.find(Routes.class, id);
	}
	
	@Override
	public List<Routes> fetchAllRoutes() {
		return entityManager.createQuery("SELECT r FROM Routes r").getResultList();
	}
	
	@Override
	public Routes fetchRoute(String fromCity, String toCity) {
		return (Routes) entityManager.createQuery("SELECT r FROM Routes r WHERE r.source = :f AND r.destination = :t")
				.setParameter("f", fromCity)
				.setParameter("t", toCity)
				.getSingleResult();
	}
	
}
