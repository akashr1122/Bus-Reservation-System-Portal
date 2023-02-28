package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.paylord.CurrentUserSession;

public interface CurrentUserSessionDao extends JpaRepository<CurrentUserSession, Integer>{

}
