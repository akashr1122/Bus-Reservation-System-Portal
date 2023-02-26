package com.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus.paylord.CurrentUserSession;
import com.bus.paylord.LoginDto;
import com.bus.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/busticket/login")
	public ResponseEntity<CurrentUserSession> loginHandler(@RequestBody LoginDto loginDto){
		 
		CurrentUserSession lDto =  loginService.login(loginDto);
		 return new ResponseEntity<CurrentUserSession>(lDto,HttpStatus.ACCEPTED);
	}

}
