package com.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Places {
	
	@Id
	@GeneratedValue
	@Column(name="placeId")
	private int pId;
	@OneToMany
	@JoinColumn(name = "source")
	private List<Flights> listOfFlights1;
	/*@JoinColumn(name = "destination")
	private List<Flights> listOfFlights2; */
	
	@Column(unique = true)
	private String placesName;
	
	@OneToMany(mappedBy = "source")
	private List<Flights> listOfFlights;
	
	public int getPlaceId() {
		return pId;
	}
	public void setPlaceId(int placeId) {
		this.pId = placeId;
	}
	
	public String getPlacesName() {
		return placesName;
	}
	public void setPlacesName(String placesName) {
		this.placesName = placesName;
	}
	public Places(int placeId, String placesName) {
		super();
		this.pId = placeId;
		this.placesName = placesName;
	}
	public Places() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
