package com.service;

import java.util.List;

import com.bean.Airlines;
import com.dao.AirlinesSetupDao;

public class AirlineSetupService {

	AirlinesSetupDao newAirlinedao = new AirlinesSetupDao();
	
	public String newAirlineSetup(Airlines newAirline) {
		String daoAirlinereturn = newAirlinedao.SaveAirlines(newAirline);
		if(daoAirlinereturn.equals("success")) {
			return "AirlineSavedSuccessfully";
		} else if (daoAirlinereturn.equals("uniqueConstraintException")){
			return "uniqueConstraintException";
		}
		return "AirlineNotSaved";
	}
	
	public List<Airlines> getAllAirlinesService() {
		return (newAirlinedao.getAllAirlines());
	}
}
