package com.bus.service;

import java.util.List;

import com.bus.model.Route;

public interface IRouteService {

	public Route addRoute(Route route);

	public Route updateRoute(Route route);

	public Route deleteRoute(int routeld);

	public Route viewRoute(int routeld);

	public List<Route> viewAllRoute();
}
