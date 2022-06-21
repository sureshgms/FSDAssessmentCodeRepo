package com.dao;

import java.util.List;
import com.bean.FlightsList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import com.bean.Airlines;
import com.bean.Flights;

public class FlightSetupDao {
	
	public String saveFlight(Flights newFlight) {
		try {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml"); // load the database and Entity class
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
			session.save(newFlight); // equal to insert
			tran.commit();
			return "success";
		}

		catch (ConstraintViolationException cve) {
			System.out.println("Exception caught here in this block");
			return "uniqueConstraintException";
		}
	}
	
	public List<Flights> getAllFlights() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml"); // load the database and Entity class
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
	/*	Query qry = session.createQuery("select flights.flightNumber,source.placesName, destination.placesName,airline.airlineName,flights.price from Flights flights, Places source, Places destination, Airlines airline"
				+ " where flights.airlineId = airline.airlineId And flights.source=source.placeId And flights.destination = destination.placeId "
				+ ""); */
	
		Query qry = session.createQuery("select flightList from Flights flightList");	
		List<Flights> listOfFlights = qry.list();
		return listOfFlights;
	}

}
