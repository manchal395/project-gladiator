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
	@Transactional
	public void addRoute(Routes route) {
		entityManager.merge(route);
	}
	
	@Override
	public Routes fetchRouteById(int id) {
		return entityManager.find(Routes.class, id);
	}
	
	@Override
	public List<Routes> fetchAllRoutes() {
		return entityManager.createQuery("SELECT r FROM Routes r").getResultList();
	}
	
}
