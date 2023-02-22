package com.bus.model;

import java.time.LocalDate;

import com.bus.paylord.Status;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Data
public class Reservation {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer reservationId;
	 
	 @Enumerated
	 private Status reservation_status;
	 
	 private String reservationType;
	 
	 private LocalDate reservationDate;
	 
	 private String Source;
	 
	 private String destination;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 private Bus reservations;

}
