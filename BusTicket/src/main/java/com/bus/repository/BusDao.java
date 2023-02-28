package com.bus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bus.model.Bus;
import com.bus.paylord.BusType;



public interface BusDao extends JpaRepository<Bus, Integer>{
	
	@Query("from Bus where routeFrom=:from and routeTo=:to")
	public List<Bus> getAllBusByRoute(@Param("from") String from,@Param("to") String to);
	
	
	@Query("SELECT DISTINCT routeFrom from Bus")
	public List<String> getAllBusByFrom();
	
	
	@Query("SELECT DISTINCT routeTo from Bus")
	public List<String> getAllBusByTo();
	
	@Query("from Bus")
	public List<Bus> getAllBus();
	
	public List<Bus> findByBusType(BusType busType);


	
}
