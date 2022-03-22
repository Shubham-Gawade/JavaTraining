package com.xoriant.companymanagementapp;

import java.time.LocalDate;

public class RegisteredCustomer extends Customer {
	
	private double regdFees; 
	private LocalDate dateOfRegistration;
	private int privilegeType;
	
	public RegisteredCustomer() {
	
	}
	
	public RegisteredCustomer(double regdFees, LocalDate dateOfRegistration, int privilegeType) {
		super();
		this.regdFees = regdFees;
		this.dateOfRegistration = dateOfRegistration;
		this.privilegeType = privilegeType;
	}
	
	public double getRegdFees() {
		return regdFees;
	}
	public void setRegdFees(double regdFees) {
		this.regdFees = regdFees;
	}
	public LocalDate getDateOfRegistration() {
		return dateOfRegistration;
	}
	public void setDateOfRegistration(LocalDate dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	public int getPrivilegeType() {
		return privilegeType;
	}
	public void setPrivilegeType(int privilegeType) {
		this.privilegeType = privilegeType;
	}
}
