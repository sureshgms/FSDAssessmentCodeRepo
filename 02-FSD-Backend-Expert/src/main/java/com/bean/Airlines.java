package com.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Airlines {
	@Id
	@GeneratedValue
	@Column(name="airlineId")
	private int aId;
	@OneToMany
	@JoinColumn(name = "airlineId")
	private List<Flights> listOfFlights;
	
	@Column(unique = true)
	private String airlineName;
	public int getAirlineId() {
		return aId;
	}
	public void setAirlineId(int airlineId) {
		this.aId = airlineId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public Airlines(int airlineId, String airlineName) {
		super();
		this.aId = airlineId;
		this.airlineName = airlineName;
	}
	public Airlines() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Airlines [airlineId=" + aId + ", airlineName=" + airlineName + "]";
	}
	
	
}
