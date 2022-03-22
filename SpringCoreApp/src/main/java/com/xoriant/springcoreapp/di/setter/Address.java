package com.xoriant.springcoreapp.di.setter;

public class Address {
	private int streetNumber;
	private String streetName;
	private String city;

	public Address() {

	}

	public Address(int streetNumber, String streetName, String city) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
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

	@Override
	public String toString() {
		return "Address [streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city + "]";
	}
	
	
}
