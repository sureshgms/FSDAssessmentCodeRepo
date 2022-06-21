package com.service;

import java.util.List;
import com.bean.FlightsList;

import com.bean.Flights;
import com.dao.FlightSetupDao;



public class FlightSetupService {
	
FlightSetupDao newFlightdao = new FlightSetupDao();
	
	public String newFlightSetup(Flights newflight) {
		String daoFlightreturn = newFlightdao.saveFlight(newflight);
		if(daoFlightreturn.equals("success")) {
			return "FlightSavedSuccessfully";
		} else if (daoFlightreturn.equals("uniqueConstraintException")){
			return "uniqueConstraintException";
		}
		return "FlightNotSaved";
	}
	
	public List<Flights> getAllFlightsService() {
		return (newFlightdao.getAllFlights());
	}

}
