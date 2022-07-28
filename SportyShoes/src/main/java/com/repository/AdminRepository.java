package com.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
	
	public Optional<Admin> findByUsernameAndPassword(String username, String password);
	
	@Modifying
	@Transactional
	@Query("update Admin a set a.password = :newPwd where a.username = :username")
	public void updateNewPassword(@Param("username") String username, @Param("newPwd") String newPwd);

}
