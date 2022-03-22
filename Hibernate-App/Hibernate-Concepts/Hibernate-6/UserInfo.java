package com.xoriant.hibernateapp.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
	
	//oracle - sequence-gen and mysql - increment-gen
	@GenericGenerator(name ="increment-gen",strategy = "increment")
	@CollectionId(columns = { @Column(name ="addressId")}, generator = "increment-gen", type=@Type(type="long"))
	private Collection<Address> address=new ArrayList<>();
	
	public void setAddress(Address address) {
		this.address.add(address);
	}

	public Collection<Address> getAddress() {
		return address;
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
