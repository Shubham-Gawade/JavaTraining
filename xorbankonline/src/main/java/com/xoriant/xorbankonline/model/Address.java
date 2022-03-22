package com.xoriant.xorbankonline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Address {
	
	@Id
	@TableGenerator(name = "Address_Gen", table = "Address_ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Address_Gen", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Address_Gen")
	private int adddressId;
	private int doorNo;
	private String city;
	private String area;
	private String state;
	private int pincode;
	
	public int getAdddressId() {
		return adddressId;
	}

	public void setAdddressId(int adddressId) {
		this.adddressId = adddressId;
	}

	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
