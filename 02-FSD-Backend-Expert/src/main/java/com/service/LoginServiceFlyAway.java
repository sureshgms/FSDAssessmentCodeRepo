package com.service;

import java.util.Iterator;
import java.util.List;

import com.bean.Users;
import com.dao.AdminLoginDao;

public class LoginServiceFlyAway {

	AdminLoginDao ld = new AdminLoginDao();

	public String checkAdminLogin(Users adminUser) {

		List<Users> listOfUsers = ld.adminLogin(adminUser);
		Iterator<Users> userList = listOfUsers.iterator();

		int count = listOfUsers.size();

		if (count == 0) {
			return "AdminLoginFailed";
		} else {
			return "AdminLoginSuccess";
		}

	}


}
