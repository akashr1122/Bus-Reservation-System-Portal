package com.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.exception.BusException;
import com.bus.model.Bus;
import com.bus.paylord.BusType;
import com.bus.repository.BusDao;

@Service
public class IBusServiceImpl implements IBusService{
	
	@Autowired
	private BusDao busdao;

	@Override
	public Bus addBus(Bus bus) {
		Bus saveBus=busdao.save(bus);
		
		return saveBus;
	}

	@Override
	public Bus updateBus(Bus bus) throws BusException {
		Optional<Bus> savedBus=busdao.findById(bus.getBusId());
		
		
		
		if(savedBus.isPresent()) {
			Bus updateBus=busdao.save(bus);
			return updateBus;
		}else {
			throw new BusException("Invalid Bus details.................");
		}
			
		
	}

	@Override
	public Bus deleteBus(int busld) throws BusException {
		Optional<Bus> opt=busdao.findById(busld);
		
		if(opt.isPresent()) {
			Bus existingBus=opt.get();
			
			busdao.delete(existingBus);
			
			return existingBus;
		}else {
			throw new BusException("Bus Does not exist with id"+busld);
		}
		
	}

	@Override
	public Bus viewBus(int busld) throws BusException {
		Optional<Bus> opt=busdao.findById(busld);
		
		if(opt.isPresent()) {
			Bus bus=opt.get();
			return bus;
		}else {
			throw new BusException("");
		}
		
		
	}

	@Override

	public List<Bus> getAllBusesByType(BusType busType) {
		  List<Bus>  buses = busdao.findByBusType(busType);
		  return buses;
	}

	@Override
	public List<Bus> viewAllBus() throws BusException{
		List<Bus> buses=busdao.findAll();
		
		if(buses==null) {
			throw new BusException("No bus available");
		}else {
			return buses;

		}

	}

}
