package com.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus.model.Bus;
import com.bus.service.IBusService;

@RestController
public class BusServiceController {

	@Autowired
	private IBusService busService;
	
	
	@PostMapping("/bus")
	public ResponseEntity<Bus> addBusHandler(@RequestBody Bus bus){
		
		Bus addBus=busService.addBus(bus);
		
		return new ResponseEntity<Bus>(addBus,HttpStatus.CREATED);
		
	}
	
	
}
