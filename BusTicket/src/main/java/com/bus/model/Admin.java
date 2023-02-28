package com.bus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Admin")
public class Admin {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aId;
	
	@NotNull
	@NotBlank
	@Column(unique = true)
	private String  username;
	
	@NotNull
	@NotBlank
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
    message = "Password must contain at least one uppercase letter, one lowercase letter, one number, one special character, and be between 8 and 20 characters")
	private String  password;
	
	

}
