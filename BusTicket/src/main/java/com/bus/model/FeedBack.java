
 package com.bus.model;
import java.sql.Date;


import org.hibernate.validator.constraints.Range;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
public class FeedBack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedBackId;
	
	@Range(min = 0, max = 5, message = "Driver rating must be between 0 and 5")
	private Float driverRating;
	
	@Range(min = 0, max = 5, message = "Service rating must be between 0 and 5")
	private Float serviceRating;
	
	@Range(min = 0, max = 5, message = "Overall rating must be between 0 and 5")
	private Float overallRating;
	
	private String comments;
	
	@NotNull(message = "Feedback date is required")
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "UTC")
	private Date feedBackDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;
}
