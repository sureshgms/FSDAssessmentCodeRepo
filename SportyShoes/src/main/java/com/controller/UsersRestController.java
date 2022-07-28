package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Users;
import com.service.UsersService;

@RestController
public class UsersRestController {
	
	@Autowired
	UsersService userService;
	
	@GetMapping("/getuserbyEmail/{email}")
	public Optional<Users> getUserByEmail(@PathVariable("email") String emailId) {
		
		return userService.findByEmailId(emailId);
		
	}

}
