package com.bus.service;

import java.time.LocalDate;
import java.util.List;

import com.bus.exception.ReservationNotFoundException;
import com.bus.model.Reservation;

public interface IReservationService {

	 String addReservation(Reservation reservation) throws ReservationNotFoundException;

	 String updateReservation(Reservation reservation)throws ReservationNotFoundException;

	 String deleteReservation(Integer reservationld)throws ReservationNotFoundException;

	 Reservation viewReservation(Integer reservationld)throws ReservationNotFoundException;

	 List<Reservation> viewAllReservation()throws ReservationNotFoundException;

	 List<Reservation> getAllReservation(LocalDate date)throws ReservationNotFoundException;
}
