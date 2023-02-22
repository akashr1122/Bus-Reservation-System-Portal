package com.bus.Impl;

import com.bus.exception.ReservationException;
import com.bus.model.Reservation;
import com.bus.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class ReseravtionService_Impl implements IReservationService {

    @Autowired
    private Reservation seats;
    @Override

    public Reservation addReservation(Reservation reservation)throws ReservationException {
        return null;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) throws ReservationException{
        return null;
    }

    @Override
    public Reservation deleteReservation(int reservationld) {
        return null;
    }

    @Override
    public Reservation viewReservation(int reservationld) {
        return null;
    }

    @Override
    public List<Reservation> viewAllReservation() {
        return null;
    }

    @Override
    public List<Reservation> getAllReservation(LocalDate date) {
        return null;
    }
}
