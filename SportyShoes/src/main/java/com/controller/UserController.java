package com.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Users;
import com.service.UsersService;

@Controller
public class UserController {

	@Autowired
	UsersService uService;
	

	@RequestMapping(value="searchUsers", method=RequestMethod.GET)
	public String searchUsers(HttpServletRequest req) {
		
		HttpSession session = req.getSession(); 
		String uName = req.getParameter("username");
		Optional<Users> user1 = uService.findByEmailId(uName);
		
		if(user1 != null) {
			session.setAttribute("user", user1);
		} else {
			session.setAttribute("user", null);
		}
		return "userFound";
	}
	
	@RequestMapping(value="searchAllUsers", method=RequestMethod.GET)
	public String allUsers(HttpServletRequest req) {
		HttpSession session = req.getSession(); 
		
		List<Users> userList = uService.findAllUsers();
		
		session.setAttribute("allusers", userList);
		
		return "allUsers";
	}

}
