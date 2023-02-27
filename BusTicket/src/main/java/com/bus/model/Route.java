package com.bus.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Route {
    

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;

	@NotNull(message = "Route from cannot be null")
	private String routeFrom;

	@NotNull(message = "Route to cannot be null")
	private String routeTo;

	@Positive(message = "Distance must be a positive integer")
	private Integer distance;

	@JsonIgnore
	@OneToMany(mappedBy = "route")
	private List<Bus> busList = new ArrayList<>();
}
