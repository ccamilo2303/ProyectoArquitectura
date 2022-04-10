package com.poli.arq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poli.arq.dao.UserDaoI;
import com.poli.arq.dto.UserDto;
import com.poli.arq.exception.ValidationException;
import com.poli.arq.helper.ValidatorHelper;

@Service
public class UserService implements UserServiceI{

	@Autowired
	private ValidatorHelper validatorHelper;

	@Autowired
	private UserDaoI userDao;


	@Override
	public void validateUser(String email, String pass) throws ValidationException{

		validatorHelper.validateRequestGerUser(email, pass);

		UserDto user = userDao.getUser(email, pass);

		validatorHelper.validateQueryUser(user); 
			
	}


}

