package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Users;
import com.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository usersRepo;
	
	public Optional<Users> findByEmailId(String email) {
		return usersRepo.findByEmailId(email);
	}
	
	public List<Users> findAllUsers() {
		return usersRepo.findAll();
	}
}
