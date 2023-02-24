package com.bus.service;

import com.bus.exception.ReservationNotFoundException;
import com.bus.model.Reservation;
import com.bus.repository.BusDao;
import com.bus.repository.ReservationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IReservationServiceImpl implements IReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private BusDao busDao;
    
    
	@Override
	public String addReservation(Reservation reservation) throws ReservationNotFoundException {
		// TODO Auto-generated method stub
		
		String string="Reservation not added successfully";
		
		reservation.setBus(busDao.findById(reservation.getBus().getBusId()).get());
	
		reservation.setReservationDate(Date.valueOf(LocalDate.now()));
		
		reservation.setSource(reservation.getBus().getRouteFrom());
		
		reservation.setDestination(reservation.getBus().getRouteTo());
		
		reservationDao.save(reservation);
		
		string="Reservation added successfully";
		
		return string;
	}

	@Override
	public String updateReservation(Reservation reservation) throws ReservationNotFoundException {
		// TODO Auto-generated method stub
	
		String string="Reservation not updated successfully";
		
		Optional<Reservation> reserve=reservationDao.findById(reservation.getReservationId());
		
		if(reserve.isEmpty()) {throw new ReservationNotFoundException("Reservation details are not present");}
		
		reservationDao.save(reservation);
		
		string="Reservation updated successfully";
		
		return string;
	}

	@Override
	public String deleteReservation(Integer reservationld) throws ReservationNotFoundException {
		// TODO Auto-generated method stub
		
		String string="Reservation not deleted successfully";
		
		Optional<Reservation> reserve=reservationDao.findById(reservationld);
		
		if(reserve.isEmpty()) {throw new ReservationNotFoundException("Reservation details are not present");}
		
		reservationDao.delete(reserve.get());
		
		string="Reservation deleted successfully";
		
		return string;
	}

	@Override
	public Reservation viewReservation(Integer reservationld) throws ReservationNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Reservation> optional=reservationDao.findById(reservationld);
		
		if(optional.isEmpty()) {throw new ReservationNotFoundException("No reservation found with the provided ID");}
		
		Reservation reservation=optional.get();
		
		
		return reservation;
	}

	@Override
	public List<Reservation> viewAllReservation() throws ReservationNotFoundException {
		// TODO Auto-generated method stub
		
		List<Reservation> list=reservationDao.findAll();
		
		if(list.isEmpty()) {throw new ReservationNotFoundException("No reservation details are present here");}
		
		
		
		
		return list;
	}

	@Override
	public List<Reservation> getAllReservation(LocalDate date) throws ReservationNotFoundException {
		// TODO Auto-generated method stub
		
		List<Reservation> reservations=reservationDao.findByReservationDate(date);
		
		if(reservations.isEmpty()) {throw new ReservationNotFoundException("No reservations are available at the provided date");}
		
		
		return reservations;
	}
    
    
    
    

    }
