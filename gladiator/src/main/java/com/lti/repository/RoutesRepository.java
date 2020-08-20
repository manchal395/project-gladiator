package com.lti.repository;


import java.util.List;

import com.lti.entity.Routes;

public interface RoutesRepository {

	void addRoute(Routes route);

	Routes fetchRouteById(int id);
	
	List<Routes> fetchAllRoutes();

}