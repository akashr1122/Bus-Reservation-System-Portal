package com.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.exception.RouteNotFoundException;
import com.bus.exception.UserNotFoundException;
import com.bus.model.Route;
import com.bus.repository.RouteDao;

@Service
public class IRouteServiceImpl implements IRouteService {

	@Autowired
	private RouteDao routeDao;

	@Override
	public Route addRoute(Route route) {
		Route r = routeDao.save(route);
		return r;
	}

	@Override
	public Route updateRoute(Route route) throws RouteNotFoundException {
		routeDao.findById(route.getRouteId())
				.orElseThrow(() -> new UserNotFoundException("This Route is not present .."));
		Route r = routeDao.save(route);

		return r;
	}

	@Override
	public String deleteRoute(int routeld) throws RouteNotFoundException {
		Route r = routeDao.findById(routeld)
				.orElseThrow(() -> new RouteNotFoundException(" Route is not present .. which id is " + routeld));

		routeDao.delete(r);
		return "Route deleted Sucessfully";

	}

	@Override
	public Route viewRoute(int routeld) throws RouteNotFoundException {

		Route r = routeDao.findById(routeld)
				.orElseThrow(() -> new RouteNotFoundException(" Route is not present .. which id is " + routeld));

		return r;
	}

	@Override
	public List<Route> viewAllRoute() throws RouteNotFoundException {

		List<Route> routes = routeDao.findAll();
		if (routes.isEmpty())
			throw new RouteNotFoundException(" Route is not present");

		return routes;
	}

}
