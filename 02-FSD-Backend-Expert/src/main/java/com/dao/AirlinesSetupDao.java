package com.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import com.bean.Airlines;

public class AirlinesSetupDao {


	public String SaveAirlines(Airlines newAirlines) {
		try {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml"); // load the database and Entity class
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
			session.save(newAirlines); // equal to insert
			tran.commit();
			return "success";
		}

		catch (ConstraintViolationException cve) {
			System.out.println("Exception caught here in this block");
			return "uniqueConstraintException";
		}

	}
	
	public List<Airlines> getAllAirlines() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml"); // load the database and Entity class
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("select airlineslist from Airlines airlineslist");
		List<Airlines> listOfairlines = qry.list();
		return listOfairlines;
	}
}
