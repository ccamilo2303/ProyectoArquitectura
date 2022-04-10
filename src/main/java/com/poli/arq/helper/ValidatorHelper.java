package com.poli.arq.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.poli.arq.constans.ErrorMenssageEnum;
import com.poli.arq.dto.UserDto;
import com.poli.arq.exception.ValidationException;

@Component
public class ValidatorHelper {

	private static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";


	public void validateRequestGerUser(String email, String pass) throws ValidationException {
		if(StringUtils.hasText(email) == false) 
			throw new ValidationException(ErrorMenssageEnum.ERROR_REQUEST_VALIDATION.getValue());
		if(StringUtils.hasText(pass) == false) 
			throw new ValidationException(ErrorMenssageEnum.ERROR_REQUEST_VALIDATION.getValue());


		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches() == false) 
			throw new ValidationException(ErrorMenssageEnum.ERROR_EMAIL_FORMAT.getValue());
	}
	
	
	public void validateQueryUser(UserDto user) throws ValidationException{
		if(user == null || user.getEmail() == null)
			throw new ValidationException(ErrorMenssageEnum.ERROR_VALIDATION_QUERY_USER.getValue());
	}

}
