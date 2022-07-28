package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Admin;
import com.service.AdminService;

@RestController
public class AdminRestController {

	
	@Autowired
	AdminService adminService;
	
	/*@GetMapping("/getAdmin/{username}")
	public Optional<Admin>   getAdmin(@PathVariable("username") String username) {
		return adminService.getAdminByUserName(username, null);
	} */
}
