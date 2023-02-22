package com.bus.service;

import java.util.List;

import com.bus.model.User;

public interface IUserService {

	 public User addUser(User user);
   
	  public User updateUser(User user);

     public  User deleteUser(int userld);
      
     public  User viewUser(int userld);

       public  List<User> viewAllUsers();
}
