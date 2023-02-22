package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.model.Bus;

public interface BusDao extends JpaRepository<Bus, Integer>{
	
	

}
