package com.bus.service;

import java.util.List;

import com.bus.exception.BusException;
import com.bus.model.Bus;

public interface IBusService {

	public Bus addBus(Bus bus) ;

	public Bus updateBus(Bus bus) throws BusException;

	public Bus deleteBus(int busld) throws BusException;

	public Bus viewBus(int busld) throws BusException;

//	public List<Bus> viewBusByType(String busType);
//
//	public List<Bus> viewAllBus();

}
