package com.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bus.model.User;
import com.bus.service.IUserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("/bus/user")
	public ResponseEntity<User> addUserHandler(@RequestBody User user) {

		User user2 = userService.addUser(user);

		return new ResponseEntity<User>(user2, HttpStatus.CREATED);

	}

	@PutMapping("/bus/user")
	public ResponseEntity<User> updateUserHandler(@RequestBody User user) {

		User user2 = userService.updateUser(user);

		return new ResponseEntity<User>(user2, HttpStatus.ACCEPTED);

	}

	@GetMapping("/bus/user/{uId}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable Integer uId) {

		User user2 = userService.viewUser(uId);

		return new ResponseEntity<User>(user2, HttpStatus.ACCEPTED);

	}

	@GetMapping("/bus/user")
	public ResponseEntity<List<User>> getAllUserHandler() {

		List<User> users = userService.viewAllUsers();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);

	}

	@DeleteMapping("/bus/user/{uId}")
	public ResponseEntity<String> deleteUserByIdHandler(@PathVariable Integer uId) {

		String user2 = userService.deleteUser(uId);

		return new ResponseEntity<String>(user2, HttpStatus.ACCEPTED);

	}

}
