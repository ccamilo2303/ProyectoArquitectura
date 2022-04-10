package com.poli.arq.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.poli.arq.dto.UserDto;

@Repository
public class UserDao implements UserDaoI {

	@Autowired
	@Qualifier("namedJdbcABC")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public UserDto getUser(String email, String pass) {

		String sql = "select id, email, pass from users where email = :email and pass = :pass;";
		Map<String, String> param = new HashMap<String, String>();
		param.put("email", email);
		param.put("pass", pass);
		try {
			UserDto user = namedParameterJdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper<UserDto>(UserDto.class));
			System.out.println(user);
			return user;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}

	}

}

