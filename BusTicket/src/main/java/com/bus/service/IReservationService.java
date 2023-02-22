package com.bus.service;

import java.time.LocalDate;
import java.util.List;

import com.bus.model.Reservation;

public interface IReservationService {

	public Reservation addReservation(Reservation reservation);

	public Reservation updateReservation(Reservation reservation);

	public Reservation deleteReservation(int reservationld);

	public Reservation viewReservation(int reservationld);

	public List<Reservation> viewAllReservation();

	public List<Reservation> getAllReservation(LocalDate date);
}
