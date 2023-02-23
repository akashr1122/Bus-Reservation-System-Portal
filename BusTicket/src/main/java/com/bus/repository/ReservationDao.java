package com.bus.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.model.Reservation;

public interface ReservationDao extends JpaRepository<Reservation, Integer>{

	
	public List<Reservation> findByReservationDate(LocalDate localDate);
	
	
	
}
