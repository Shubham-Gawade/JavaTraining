package com.xoriant.hibernateapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Address {

	@Id
	private int addressId;
	private int doorNO;
	private String streetName;
	private String city;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "addressId"), inverseJoinColumns = @JoinColumn(name = "userId"))
	private List<UserInfo> userInfo=new ArrayList<UserInfo>();

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

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

	public void addUserInfo(UserInfo userInfo) {
		this.userInfo.add(userInfo);
	}

	public List<UserInfo> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(List<UserInfo> userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "Address [doorNO=" + doorNO + ", streetName=" + streetName + ", city=" + city + "]";
	}

}
