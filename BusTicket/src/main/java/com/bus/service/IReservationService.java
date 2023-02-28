package com.bus.service;

import java.time.LocalDate;
import java.util.List;

import com.bus.exception.ReservationNotFoundException;
import com.bus.model.Reservation;
import com.bus.model.User;

public interface IReservationService {

	 User addReservation(Integer uId,Integer bId) throws ReservationNotFoundException;

	 String updateReservation(Reservation reservation)throws ReservationNotFoundException;

	 String deleteReservation(Integer reservationld)throws ReservationNotFoundException;

	 Reservation viewReservation(Integer reservationld)throws ReservationNotFoundException;

	 List<Reservation> viewAllReservation()throws ReservationNotFoundException;

	 List<Reservation> getAllReservation(LocalDate date)throws ReservationNotFoundException;
}
