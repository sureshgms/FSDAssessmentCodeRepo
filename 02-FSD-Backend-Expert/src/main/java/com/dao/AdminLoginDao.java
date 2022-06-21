package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Users;

public class AdminLoginDao {

	public List<Users> adminLogin(Users adminUser) {

		try {

			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml"); // load the database and Entity class
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession();

			Query qry1 = session.createNativeQuery("select * from users where username = :username and password = :pass");
			qry1.setParameter("username", adminUser.getUserName());
			qry1.setParameter("pass", adminUser.getPassword());
			List<Users> listOfUsers = qry1.list();
			return listOfUsers;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

}
