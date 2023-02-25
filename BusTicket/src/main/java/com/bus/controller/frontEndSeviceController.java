package com.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bus.frontEnd.frontEndService;
import com.bus.model.Bus;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class frontEndSeviceController {

	@Autowired
	private frontEndService endService;
	
	
	@GetMapping("/bus/route/{routeFrom}/{routeTo}")
	public ResponseEntity<List<Bus>> getAllBusByRoute( @Valid @PathVariable(name = "routeFrom") String from,@PathVariable(name = "routeTo") String to){
		
		List<Bus> bus=endService.getAllBusByRoute(from, to);
		
	
		
		return new ResponseEntity<List<Bus>>(bus,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/buses")
	public ResponseEntity<List<Bus>> getAllBus(){
		
		List<Bus> bus=endService.getAllBus();
		
	
		
		return new ResponseEntity<List<Bus>>(bus,HttpStatus.ACCEPTED);
	}
	
	
	
	
	@GetMapping("/bus/routeFrom")
	public ResponseEntity<List<String>> getAllBusByFrom(){
		
		List<String> strings=endService.getAllBusByFrom();
		
	
		
		return new ResponseEntity<List<String>>(strings,HttpStatus.OK);
	}
	
	
	@GetMapping("/bus/routeTo")
	public ResponseEntity<List<String>> getAllBusByTo(){
		
		List<String> strings=endService.getAllBusByTo();
		
	
		
		return new ResponseEntity<List<String>>(strings,HttpStatus.OK);
	}
	
	
	
	
}
