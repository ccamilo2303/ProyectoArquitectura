package com.poli.arq.dao;

import com.poli.arq.dto.UserDto;

public interface UserDaoI {
	
	public UserDto getUser(String email, String pass);
	
}
