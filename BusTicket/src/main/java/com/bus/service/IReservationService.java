package com.bus.service;

import java.time.LocalDate;
import java.util.List;

import com.bus.exception.ReservationException;
import com.bus.model.Reservation;

public interface IReservationService {

	 Reservation addReservation(Reservation reservation) throws ReservationException;

	 Reservation updateReservation(Reservation reservation)throws ReservationException;

	 Reservation deleteReservation(int reservationld)throws ReservationException;

	 Reservation viewReservation(int reservationld)throws ReservationException;

	 List<Reservation> viewAllReservation()throws ReservationException;

	 List<Reservation> getAllReservation(LocalDate date)throws ReservationException;
}
