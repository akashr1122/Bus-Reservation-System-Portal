package com.bus.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.exception.LoginException;
import com.bus.model.Admin;
import com.bus.model.User;
import com.bus.paylord.CurrentUserSession;
import com.bus.paylord.LoginDto;
import com.bus.repository.AdminDao;
import com.bus.repository.CurrentUserSessionDao;
import com.bus.repository.UserDao;

@Service
public class LoginServiceImpl  implements LoginService {
        @Autowired
	  private CurrentUserSessionDao cuDao;
        
        @Autowired
        private AdminDao adminDao;
        
        @Autowired
        private UserDao userDao;
        
	@Override
	public CurrentUserSession login(LoginDto logindto) throws LoginException {
		
		User existingUser =  userDao.findByUsername(logindto.getUsername());
	   if(existingUser != null){
		   

			Optional<CurrentUserSession> validCustomerSessionOpt = cuDao.findById(existingUser.getUserId());

			if (validCustomerSessionOpt.isPresent() && existingUser.getPassword().equals(logindto.getPassword())) {
				cuDao.delete(validCustomerSessionOpt.get());
			}
			

			if (existingUser.getPassword().equals(logindto.getPassword())) {

				String key = RandomStringUtils.randomAlphanumeric(6);

				Boolean isAdmin = false;
				
				CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getUserId(),existingUser.getUsername(), key, isAdmin,LocalDateTime.now());
						

				cuDao.save(currentUserSession);

				return currentUserSession;
	   }
			else {
				throw new LoginException("Please Enter a valid password");
		   
			
	   }
	   }


			
			Admin existingAdmin = adminDao.findByUsername(logindto.getUsername());
			
			if(existingAdmin == null) {
				throw new LoginException("Invalid credentials. Username does not exist with this username -" + logindto.getUsername());	

			}
			
			
			else {

				Optional<CurrentUserSession> validCustomerSession = cuDao.findById(existingAdmin.getAId());

				if (validCustomerSession.isPresent() && existingAdmin.getPassword().equals(logindto.getPassword())) {
					cuDao.delete(validCustomerSession.get());
				}

				if (existingAdmin.getPassword().equals(logindto.getPassword())) {

					String key = RandomStringUtils.randomAlphanumeric(6);


					Boolean isAdmin = true;

					CurrentUserSession currentUserSession = new CurrentUserSession(existingAdmin.getAId(),existingAdmin.getUsername(), key, isAdmin,LocalDateTime.now());
					

					cuDao.save(currentUserSession);

					return currentUserSession;
		   }
				else {
					throw new LoginException("Please Enter a valid password");
			   
				
		   }
				
			}
			
	   }
	}
		
	
	
	


