package com.xoriant.hibernateapp.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private int doorNO;
	private String streetName;
	private String city;

	public int getDoorNO() {
		return doorNO;
	}

	public void setDoorNO(int doorNO) {
		this.doorNO = doorNO;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
