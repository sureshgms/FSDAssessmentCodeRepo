package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Admin;
import com.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepo;
	
	public Optional<Admin> getAdminByUserName(String username, String password) {
		return adminRepo.findByUsernameAndPassword(username, password);
	}
	
	public String saveNewPassword(String username, String password) {
		adminRepo.updateNewPassword(username, password);
		return "successfullyUpdated";
	}

}
