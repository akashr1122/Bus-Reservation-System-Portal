package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.model.Route;

public interface RouteDao extends JpaRepository<Route, Integer>{

}
