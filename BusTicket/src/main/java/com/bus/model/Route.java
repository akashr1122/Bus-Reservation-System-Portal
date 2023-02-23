package com.bus.model;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

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
	 private String routeFrom;
	 private String routeTo;
	 private Integer distance;
	 
	 @OneToMany(mappedBy = "route")
	 private List<Bus> busList  = new ArrayList<>();
}
