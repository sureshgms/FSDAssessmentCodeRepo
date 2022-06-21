package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.bean.Users;

public class ChangePasswordDao {

	public boolean changePassword(Users adminUser, String newPassword) {
		try {

			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml"); // load the database and Entity class
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();

			Users user1 = session.get(Users.class, adminUser.getuserId());

			if (user1 == null) {
				return false;
			} else {
				tran.begin();
				user1.setPassword(newPassword);
				session.update(user1);
				tran.commit();
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error in ChangePassword: " + e);
			return false;
		}

	}
}
