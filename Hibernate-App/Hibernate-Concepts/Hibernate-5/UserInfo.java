package com.xoriant.hibernateapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	
	@Embedded
	@ElementCollection
	//@CollectionTable(name = "user_address", joinColumns = @JoinColumn(name= "userId"))
	@JoinTable(name = "user_address", joinColumns = @JoinColumn(name= "userId"))
	private Set<Address> address=new HashSet<Address>();
	
	public void setAddress(Address address) {
		this.address.add(address);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
