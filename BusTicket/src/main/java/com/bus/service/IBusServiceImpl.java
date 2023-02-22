package com.bus.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.exception.BusException;
import com.bus.model.Bus;
import com.bus.repository.BusDao;

@Service
public class IBusServiceImpl implements IBusService{
	
	@Autowired
	private BusDao bdao;

	@Override
	public Bus addBus(Bus bus) {
		Bus saveBus=bdao.save(bus);
		
		return saveBus;
	}

	@Override
	public Bus updateBus(Bus bus) throws BusException {
		Optional<Bus> savedBus=bdao.findById(bus.getBusId());
		
		
		
		if(savedBus.isPresent()) {
			Bus updateBus=bdao.save(bus);
			return updateBus;
		}else {
			throw new BusException("Invalid Bus details.................");
		}
			
		
	}

	@Override
	public Bus deleteBus(int busld) throws BusException {
		Optional<Bus> opt=bdao.findById(busld);
		
		if(opt.isPresent()) {
			Bus existingBus=opt.get();
			
			bdao.delete(existingBus);
			
			return existingBus;
		}else {
			throw new BusException("Bus Does not exist with id"+busld);
		}
		
	}

	@Override
	public Bus viewBus(int busld) throws BusException {
		Optional<Bus> opt=bdao.findById(busld);
		
		if(opt.isPresent()) {
			Bus bus=opt.get();
			return bus;
		}else {
			throw new BusException("");
		}
		
		
	}

}
