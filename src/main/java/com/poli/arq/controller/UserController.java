package com.poli.arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poli.arq.constans.SuccessMenssageEnum;
import com.poli.arq.exception.ValidationException;
import com.poli.arq.service.UserServiceI;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/user")
public class UserController {


	@Autowired
	private UserServiceI userService;

	@GetMapping("/{email}/{pass}")
	public ResponseEntity<?> validateUser(@PathVariable("email")String email, @PathVariable("pass") String pass) {

		try {
			System.out.println("EMAIL: "+email);
			System.out.println("PASS: "+pass);
			userService.validateUser(email, pass);
			return ResponseEntity.ok(SuccessMenssageEnum.LOGIN_MESSAGE_OK.getValue());
			
		}catch(ValidationException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}