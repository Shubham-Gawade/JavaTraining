package com.xoriant.companyorderapp.entities;

public class RegisteredCustomer extends Customer {
	private double specialDiscount;

	
	public RegisteredCustomer(String customerName) {
		super(customerName);
	}

	public double getSpecialDiscount() {
		return specialDiscount;
	}

	public void setSpecialDiscount(double specialDiscount) {
		this.specialDiscount = specialDiscount;
	}

	@Override
	public String toString() {
		return "RegisteredCustomer [specialDiscount=" + specialDiscount + ", customerName=" + customerName + ", orders="
				+ orders + "]";
	}
}
