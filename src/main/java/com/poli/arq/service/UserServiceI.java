package com.poli.arq.service;

import com.poli.arq.exception.ValidationException;

public interface UserServiceI {

	public void validateUser(String email, String pass) throws ValidationException;
	
}
