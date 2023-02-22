package com.bus.service;

import java.util.List;

import com.bus.model.Bus;

public interface IBusService {

	public Bus addBus(Bus bus);

	public Bus updateBus(Bus bus);

	public Bus deleteBus(int busld);

	public Bus viewBus(int busld);

	public List<Bus> viewBusByType(String busType);

	public List<Bus> viewAllBus();

}
