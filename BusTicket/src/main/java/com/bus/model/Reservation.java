package com.bus.model;

import java.time.LocalDate;

import com.bus.paylord.Stutus;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Reservation {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer reservationId;
	 
	 @Enumerated
	 private Stutus reservationstutus;
	 
	 private String reservationType;
	 
	 private LocalDate reservationDate;
	 
	 private String Source;
	 
	 private String destination;
	 
	 @ManyToOne
	 private Bus bus;
	 
}
