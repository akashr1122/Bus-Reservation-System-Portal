package com.bus.paylord;

	

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	import lombok.ToString;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	@Entity
	public class CurrentUserSession {
		@Id
		@Column(unique = true)
		private Integer userId;
		
		private String username;

		private String uuid;

		private Boolean admin;

		private LocalDateTime localDateTime;
	}

