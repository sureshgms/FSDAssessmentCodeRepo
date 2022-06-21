package com.service;

import com.bean.Users;
import com.dao.ChangePasswordDao;

public class ChangePassword {
	
	ChangePasswordDao chpwd = new ChangePasswordDao();
	
	public String changePwd(Users adminUser, String newPassword) {
		
		if(chpwd.changePassword(adminUser, newPassword)) {
			return "PasswordChangeSuccessfull";
		} else {
			return "PasswordChangeFailure";
		}
	}

	
}
