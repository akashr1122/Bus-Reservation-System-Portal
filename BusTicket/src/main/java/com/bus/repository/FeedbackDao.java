package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.model.FeedBack;

public interface FeedbackDao extends JpaRepository<FeedBack, Integer>{

}
