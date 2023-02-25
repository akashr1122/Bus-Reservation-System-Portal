package com.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus.model.Route;
import com.bus.service.IRouteService;

import jakarta.validation.Valid;



@RestController
@CrossOrigin(origins = "*")
public class RouteController {
	
	
	@Autowired
	private IRouteService routeService;

	@PostMapping("/bus/route")
	public ResponseEntity<Route> addRouteHandler(@Valid @RequestBody Route route) {

		Route route2 = routeService.addRoute(route);

		return new ResponseEntity<Route>(route2, HttpStatus.CREATED);

	}

	@PutMapping("/bus/route")
	public ResponseEntity<Route> updateRouteHandler(@Valid @RequestBody Route route) {

		Route route2 = routeService.updateRoute(route);

		return new ResponseEntity<Route>(route2, HttpStatus.ACCEPTED);

	}

	@GetMapping("/bus/route/{rId}")
	public ResponseEntity<Route> getRouteByIdHandler(@PathVariable Integer rId) {

		Route route2 = routeService.viewRoute(rId);

		return new ResponseEntity<Route>(route2, HttpStatus.ACCEPTED);

	}

	@GetMapping("/bus/route")
	public ResponseEntity<List<Route>> getAllRouteHandler() {

		List<Route> routes = routeService.viewAllRoute();

		return new ResponseEntity<List<Route>>(routes, HttpStatus.OK);

	}

	@DeleteMapping("/bus/route/{rId}")
	public ResponseEntity<String> deleteRouteByIdHandler(@PathVariable Integer rId) {

		String route2 = routeService.deleteRoute(rId);

		return new ResponseEntity<String>(route2, HttpStatus.ACCEPTED);


}

}