package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
