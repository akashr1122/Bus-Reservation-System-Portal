package com.bus.service;

import java.util.List;

import com.bus.exception.RouteNotFoundException;
import com.bus.model.Route;

public interface IRouteService {

	public Route addRoute(Route route);

	public Route updateRoute(Route route) throws RouteNotFoundException;

	public String deleteRoute(int routeld)throws RouteNotFoundException;

	public Route viewRoute(int routeld) throws RouteNotFoundException;

	public List<Route> viewAllRoute() throws RouteNotFoundException;
}
