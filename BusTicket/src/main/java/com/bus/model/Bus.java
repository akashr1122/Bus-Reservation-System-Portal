package com.bus.model;

import java.sql.Time;

import com.bus.paylord.BusType;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId;

	@NotNull
	private String busName;
	
	
	@Enumerated(EnumType.STRING)
	private BusType busType;


	@NotNull
	private String routeFrom;
	@NotNull
	private String routeTo;
	@NotNull(message = "arrivalTime can't be null")
	@JsonFormat(pattern = "HH:mm:ss", timezone = "UTC")
	private Time arrivalTime = Time.valueOf("00:00:00");

	@NotNull
	private Integer seats;
	@NotNull
	private Integer avaialableSeats;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Route route;
	
	 
	
	
	

}
