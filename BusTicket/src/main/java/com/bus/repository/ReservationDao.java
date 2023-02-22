package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.model.Reservation;

public interface ReservationDao extends JpaRepository<Reservation, Integer>{

}
