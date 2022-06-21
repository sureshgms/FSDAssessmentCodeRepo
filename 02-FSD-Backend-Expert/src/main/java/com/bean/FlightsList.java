package com.bean;

public class FlightsList {
	private String flightNumber;
	private String sourcePlace;
	private String destinationPlace;
	private String airlineName;
	private float flightPrice;
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
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public float getFlightPrice() {
		return flightPrice;
	}
	public void setFlightPrice(float flightPrice) {
		this.flightPrice = flightPrice;
	}
	public FlightsList(String flightNumber, String sourcePlace, String destinationPlace, String airlineName,
			float flightPrice) {
		super();
		this.flightNumber = flightNumber;
		this.sourcePlace = sourcePlace;
		this.destinationPlace = destinationPlace;
		this.airlineName = airlineName;
		this.flightPrice = flightPrice;
	}
	public FlightsList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
