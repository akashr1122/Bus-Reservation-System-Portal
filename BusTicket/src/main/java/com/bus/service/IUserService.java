package com.bus.service;

import java.util.List;

import com.bus.model.User;

public interface IUserService {

	  User addUser(User user);
   
      User updateUser(User user);

      User deleteUser(int userld);
      
      User viewUser(int userld);

      List<User> viewAllUsers();
}
