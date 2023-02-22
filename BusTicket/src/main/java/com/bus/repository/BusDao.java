package com.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bus.model.Bus;



public interface BusDao extends JpaRepository<Bus, Integer>{
	
	@Query("select * from bus b where b.routefrom=:from and b.routeto=:to")
	public List<Bus> getAllBusByRoute(@Param("from") String from,@Param("to") String to);

	
}
