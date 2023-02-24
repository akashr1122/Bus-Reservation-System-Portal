package com.bus.controller;

import java.time.LocalDate;
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

import com.bus.model.Reservation;
import com.bus.service.IReservationService;

@RestController
@CrossOrigin(origins = "*")
public class ReservationServiceController {

	@Autowired
	private IReservationService iReservationService;

	@PostMapping("/reservation/add")
	public ResponseEntity<String> addReservationController(@RequestBody Reservation reservation) {

		String string = iReservationService.addReservation(reservation);

		return new ResponseEntity<String>(string, HttpStatus.CREATED);
	}

	@PutMapping("/reservation/update")
	public ResponseEntity<String> updateReservationController(@RequestBody Reservation reservation) {

		String string = iReservationService.updateReservation(reservation);

		return new ResponseEntity<String>(string, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/reservation/{deleteid}")
	public ResponseEntity<String> deleteReservationByIdController(@PathVariable(name="reservationId") Integer rid) {

		String string = iReservationService.deleteReservation(rid);

		return new ResponseEntity<String>(string, HttpStatus.OK);
	}
	
	@GetMapping("/reservation/{viewid}")
	public ResponseEntity<Reservation> viewReservationController(@PathVariable(name="reservationId") Integer rid){
		
		Reservation reservation=iReservationService.viewReservation(rid);
		
		return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/reservations")
	public ResponseEntity<List<Reservation>> viewAllReservationController(){
		
		List<Reservation> list=iReservationService.viewAllReservation();
		
		return new ResponseEntity<List<Reservation>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/reservations/{reservationdate}")
	public ResponseEntity<List<Reservation>> getAllReservationController(@PathVariable(name="reservationDate") LocalDate ldate){
		
		List<Reservation> list=iReservationService.getAllReservation(ldate);
		
		return new ResponseEntity<List<Reservation>>(list,HttpStatus.OK);
		
	}
	
	

}
