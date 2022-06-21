package com.bean;

import javax.servlet.http.HttpSession;

public class AvailableFlights {

	private String flightNumber;
	private String sourcePlace;
	private String destinationPlace;
	private String flightDate;
	private float price;

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getSourcePlace() {
		return sourcePlace;
	}

	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}

	public String getDestinationPlace() {
		return destinationPlace;
	}

	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}

	public AvailableFlights(String flightNumber, String sourcePlace, String destinationPlace, String flightDate,
			float price) {
		super();
		this.flightNumber = flightNumber;
		this.sourcePlace = sourcePlace;
		this.destinationPlace = destinationPlace;
		this.flightDate = flightDate;
		this.price = price;
	}

	public AvailableFlights() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		
		return "Flight Number |" + flightNumber + "|" + "Source Place |" + sourcePlace + "|" + "Target Place |" +destinationPlace + "|" + "Travel Date |" + flightDate + "|" + "Total Price |" + price;
	}

}
