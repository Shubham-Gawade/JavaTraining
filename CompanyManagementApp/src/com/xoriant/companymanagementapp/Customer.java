package com.xoriant.companymanagementapp;

import java.time.LocalDate;


public class Customer extends Person{

	protected int customerId;
	protected LocalDate dateOfMemberShip;
	
	public Customer() {
	}
	
	public Customer(int customerId,LocalDate dateOfMemberShip) {
		super();
		this.customerId = customerId;
		this.dateOfMemberShip = dateOfMemberShip;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public LocalDate getDateOfMemberShip() {
		return dateOfMemberShip;
	}

	public void setDateOfMemberShip(LocalDate dateOfMemberShip) {
		this.dateOfMemberShip =dateOfMemberShip;
	}
}
