package com.bus.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
		
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@NotBlank(message = "Username is required")
	@Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
	@Column(unique = true)
	private String username;

	@NotBlank(message = "Email is required")
	@Email(message = "Email format is invalid")
	private String email;

	@NotBlank(message = "Contact is required")
	@Pattern(regexp = "^\\d{10}$", message = "Contact must be a 10-digit number")
	private String contact;

	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
	         message = "Password must contain at least one uppercase letter, one lowercase letter, one number, one special character, and be between 8 and 20 characters")
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	private Reservation reservation;
	
	
	

}
