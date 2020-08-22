package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.FlightSchedule;
import com.lti.entity.Schedule;

@Repository
public class SchedulesRepositoryImpl implements SchedulesRepository {
	
	//add schedule
	//fetch schedule
	//add flight schedule
	//fetch flight schedule
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addSchedule(Schedule schedule) {
		entityManager.merge(schedule);
	}
	
	@Override
	public void addFlightSchedule(FlightSchedule flightSchedule) {
		entityManager.merge(flightSchedule);
	}
	
	@Override
	public List<Schedule> fetchAllSchedules() {
		return entityManager.createQuery("SELECT s FROM Schedule s").getResultList();
	}
	
	@Override
	public List<FlightSchedule> fetchAllFlightSchedules() {
		return entityManager.createQuery("SELECT fs FROM FlightSchedule fs").getResultList();
	}

	@Override
	public int fetchScheduleId() {
		return (int) entityManager.createQuery("SELECT MAX(s.id) FROM Schedule s").getSingleResult();
	}
	
}
