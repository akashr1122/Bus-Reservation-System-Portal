package com.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bus.paylord.CurrentUserSession;
import com.bus.paylord.LoginDto;
import com.bus.service.LoginService;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/busticket/login/{username}/{password}")
	public ResponseEntity<CurrentUserSession> loginHandler(@PathVariable String username,@PathVariable String password ){
		
		LoginDto loginDto = new LoginDto();
		  loginDto.setPassword(password);
		  loginDto.setUsername(username);
		 
		CurrentUserSession lDto =  loginService.login(loginDto);
		 return new ResponseEntity<CurrentUserSession>(lDto,HttpStatus.ACCEPTED);
	}

}
