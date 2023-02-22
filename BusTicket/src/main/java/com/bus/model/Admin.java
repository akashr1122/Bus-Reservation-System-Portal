package com.bus.model;

import com.bus.paylord.Stutus;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "Admin")
public class Admin {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aId;
	
	@NotNull
	@NotBlank
	private String  name;
	
	@NotNull
	@NotBlank
	private String  password;
	
	

}
