package com.lti.repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.dto.SearchFlightDto;
import com.lti.entity.FlightSchedule;
import com.lti.entity.Schedule;


@Repository
public class SchedulesRepositoryImpl implements SchedulesRepository {

	// add schedule
	// fetch schedule
	// add flight schedule
	// fetch flight schedule

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
	
	@Override
	public int fetchFlightScheduleId() {
		return (int) entityManager.createQuery("SELECT MAX(fs.id) FROM FlightSchedule fs").getSingleResult();
	}
	
	@Override
	public List<FlightSchedule> fetchFlightScheduleById(int id) {
		return entityManager.createQuery("SELECT fs FROM FlightSchedule fs WHERE fs.flight.id = :id")
				.setParameter("id",	id)
				.getResultList();
	}

	@Override
	public FlightSchedule fetchSingleFlightScheduleById(int id) {
		return (FlightSchedule) entityManager.createQuery("SELECT fs FROM FlightSchedule fs WHERE fs.id = :id")
				.setParameter("id",	id)
				.getSingleResult();
	}
	
	@Override
	public List<Object[]> fetchSearchedFlights(SearchFlightDto sfdto, int bs, int es) {
		return entityManager.createQuery("SELECT f.airlines, f.id, fs.id, fs.economy, fs.business, r.source, r.destination, s.depart, s.arrive "
				+ "FROM FlightSchedule fs INNER JOIN fs.flight f INNER JOIN fs.schedule s INNER JOIN fs.schedule.route r "
				+ "WHERE r.source = :from AND r.destination = :to AND TRUNC(s.depart) = TRUNC(:dept) AND fs.status = :st AND fs.economySeatsAvailable >= :es "
				+ "AND fs.businessSeatsAvailable >= :bs ORDER BY s.depart")
				.setParameter("from", sfdto.getSource())
				.setParameter("to", sfdto.getDestination())
				.setParameter("dept", LocalDateTime.of(sfdto.getDepart(), LocalTime.now()))
				.setParameter("st", "AVAILABLE")
				.setParameter("es", es)
				.setParameter("bs", bs)
				.getResultList();
	}
	
}
