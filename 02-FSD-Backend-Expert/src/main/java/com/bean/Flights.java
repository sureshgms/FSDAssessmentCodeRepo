package com.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Flights {
	@Id
	@GeneratedValue
	private int flightId;
	private String flightNumber;
	
	private int airlineId;
	private int source;
	private int destination;
	private float price;
	
	@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="pId")
	@JoinColumn(name="source", referencedColumnName = "placeId",insertable=false, updatable=false)
	private Places sourcePlace;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="destination", referencedColumnName = "placeId",insertable=false, updatable=false)
	private Places destinationPlace; 

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="airlineId", referencedColumnName = "airlineId",insertable=false, updatable=false)
	private Airlines airlineName;  
	
	public Places getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(Places sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public Places getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(Places destinationPlace) {
		this.destinationPlace = destinationPlace; 
	}
	public Airlines getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(Airlines airlineName) {
		this.airlineName = airlineName;
	} 
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void flights(int flightId, String flightNumber, int airlineId, int source, int destination, float price) {
		
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.airlineId = airlineId;
		this.source = source;
		this.destination = destination;
		this.price = price;
	}

	

}
