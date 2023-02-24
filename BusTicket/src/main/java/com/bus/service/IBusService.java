package com.bus.service;

import java.util.List;
import java.util.Optional;

import com.bus.exception.BusException;
import com.bus.model.Bus;
import com.bus.paylord.BusType;

public interface IBusService {

	public Bus addBus(Bus bus) ;

	public Bus updateBus(Bus bus) throws BusException;

	public Bus deleteBus(int busld) throws BusException;

	public Bus viewBus(int busld) throws BusException;

	public List<Bus> getAllBusesByType(BusType busType)throws BusException;

	public List<Bus> viewAllBus()throws BusException;

}
