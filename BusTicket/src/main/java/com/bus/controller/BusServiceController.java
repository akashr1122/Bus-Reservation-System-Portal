package com.bus.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bus.exception.BusException;
import com.bus.model.Bus;
import com.bus.paylord.BusType;
import com.bus.service.IBusService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/busticket")
@CrossOrigin(origins = "*")
public class BusServiceController {

	@Autowired
	private IBusService busService;
	
	
	@PostMapping("/bus")
	public ResponseEntity<Bus> addBusHandler(@Valid @RequestBody Bus bus){
		
		Bus addBus=busService.addBus(bus);
		
		return new ResponseEntity<Bus>(addBus,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/bus")
	public ResponseEntity<Bus> updateBusHandler( @Valid @RequestBody Bus bus) throws BusException{
		
		Bus updateBus = busService.updateBus(bus);
		 
		return new ResponseEntity<Bus>(updateBus,HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/bus/{bId}")
	public ResponseEntity<Bus> getBusByIdHandler(@PathVariable Integer bId) throws BusException{
		
		Bus getBus = busService.viewBus(bId);
		 
		return new ResponseEntity<Bus>(getBus,HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/buseses")
	public ResponseEntity<List<Bus>> getAllBusHandler() throws BusException{
		
		List<Bus>getBuses = busService.viewAllBus();
		 
		return new ResponseEntity<List<Bus>>(getBuses,HttpStatus.OK);

	}
	
	@DeleteMapping("/bus/{bId}")
	public ResponseEntity<Bus> deleteBusByIdHandler(@PathVariable Integer bId) throws BusException{
		
		Bus deleteBus = busService.deleteBus(bId);
		 
		return new ResponseEntity<Bus>(deleteBus,HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/bus")
	public ResponseEntity<List<Bus>> getBusByTypeHandler( @Valid @RequestParam("type") String busType) throws BusException{
		
		List<Bus>  getBus = busService.getAllBusesByType(BusType.valueOf(busType.toUpperCase()));
		 
		return new ResponseEntity<List<Bus>>(getBus,HttpStatus.ACCEPTED);

	}
	
	
}
