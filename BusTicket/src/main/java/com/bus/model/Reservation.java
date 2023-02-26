package com.bus.model;

import java.sql.Date;
import java.time.LocalDateTime;

import com.bus.paylord.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

	@NotNull(message = "Reservation status is required")
	@Enumerated(EnumType.STRING)
	private Status reservationStatus;

	@NotBlank(message = "Reservation type is required")
	@Size(min = 3, max = 50, message = "Reservation type must be between 3 and 50 characters")
	private String reservationType;

	@NotNull(message = "Reservation date is required")
	@NotNull
	private LocalDateTime reservationDate;

	@NotBlank(message = "Source is required")
	@Size(min = 3, max = 50, message = "Source must be between 3 and 50 characters")
	private String source;

	@NotBlank(message = "Destination is required")
	@Size(min = 3, max = 50, message = "Destination must be between 3 and 50 characters")
	private String destination;

	@NotNull(message = "Bus is required")
	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;
	 
}
