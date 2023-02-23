package com.bus.service;

import java.util.List;

import com.bus.exception.UserNotFoundException;
import com.bus.model.User;

public interface IUserService {

	  User addUser(User user) ;
   
      User updateUser(User user) throws UserNotFoundException;

      String deleteUser(int userld) throws UserNotFoundException;
      
      User viewUser(int userld) throws UserNotFoundException ;

      List<User> viewAllUsers() throws UserNotFoundException;
}
