package com.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.exception.UserNotFoundException;
import com.bus.model.User;
import com.bus.repository.UserDao;


@Service
public class IUserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User addUser(User user) {
	    User savedUser = userDao.save(user);
	    return savedUser;
	}

	@Override
	public User updateUser(User user) throws UserNotFoundException {

		userDao.findById(user.getUserId()).orElseThrow(() -> new UserNotFoundException("This User is not present .."));
		User u = userDao.save(user);

		return u;

	}

	@Override
	public String deleteUser(int userld) throws UserNotFoundException {

		User u = userDao.findById(userld)
				.orElseThrow(() -> new UserNotFoundException(" Useris not present .. which id is " + userld));

		userDao.delete(u);
		return "User deleted Sucessfully";

	}

	@Override
	public User viewUser(int userld) throws UserNotFoundException {

		User u = userDao.findById(userld)
				.orElseThrow(() -> new UserNotFoundException(" Useris not present .. which id is " + userld));

		return u;
	}

	@Override
	public List<User> viewAllUsers() throws UserNotFoundException {

		List<User> users = userDao.findAll();
		if (users.isEmpty())
			throw new UserNotFoundException("No any User  present");
		return users;
	}

}
