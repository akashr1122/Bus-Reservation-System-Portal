package com.bus.service;

import com.bus.exception.LoginException;
import com.bus.paylord.CurrentUserSession;
import com.bus.paylord.LoginDto;

public interface LoginService {
	
	public CurrentUserSession login(LoginDto logindto) throws LoginException;

}
