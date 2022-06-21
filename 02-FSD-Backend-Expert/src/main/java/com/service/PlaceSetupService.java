package com.service;

import java.util.List;

import com.bean.Places;
import com.dao.PlacesSetupDao;

public class PlaceSetupService {

	PlacesSetupDao newPlacedao = new PlacesSetupDao();
	
	public String newPlaceSetup(Places newPlace) {
		String daoPlacereturn = newPlacedao.SavePlace(newPlace);
		if(daoPlacereturn.equals("success")) {
			return "placeSavedSuccessfully";
		} else if (daoPlacereturn.equals("uniqueConstraintException")){
			return "uniqueConstraintException";
		}
		return "placesNotSaved";
	}
	
	public List<Places> getAllPlacesService() {
		return (newPlacedao.getAllPlaces());
	}
}
