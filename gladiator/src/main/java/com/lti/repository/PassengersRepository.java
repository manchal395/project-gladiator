package com.lti.repository;

import java.util.List;

import com.lti.entity.Passengers;

public interface PassengersRepository {

	List<Passengers> fetchPassengerByPnr(int pnr);

}