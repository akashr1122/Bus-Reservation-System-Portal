package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {

	
	public Admin findByUsername(String uName);
}
