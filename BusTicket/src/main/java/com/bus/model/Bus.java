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
import jakarta.validation.constraints.Positive;
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

	@NotNull(message = "Bus name cannot be null")
	private String busName;

	@Enumerated(EnumType.STRING)
	private BusType busType;

	@NotNull(message = "Route from cannot be null")
	private String routeFrom;

	@NotNull(message = "Route to cannot be null")
	private String routeTo;

	@NotNull(message = "Arrival time cannot be null")
	@JsonFormat(pattern = "HH:mm:ss", timezone = "UTC")
	private Time arrivalTime;

	@NotNull(message = "Number of seats cannot be null")
	@Positive(message = "Number of seats must be positive")
	private Integer seats;

	@NotNull(message = "Number of available seats cannot be null")
	
	private Integer availableSeats;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Route route;
	 
	
	
	

}
