package com.bus.paylord;

import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BusDto {
	
	private Integer busId;

	@NotNull(message = "Bus name cannot be Empty")
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


}
