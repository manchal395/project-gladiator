package com.lti.repository;


import java.util.List;

import com.lti.entity.Routes;

public interface RoutesRepository {

	Routes fetchRouteById(int id);
	
	List<Routes> fetchAllRoutes();

	Routes fetchRoute(String fromCity, String toCity);

}