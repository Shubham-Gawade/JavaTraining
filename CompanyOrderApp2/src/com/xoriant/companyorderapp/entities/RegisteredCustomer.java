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
	
	public double getRegisteredCustomerTotalOrderPrice() {
		double registeredCustomerTotalOrderPrice = 0;
		for(Order order:orders) {
			double discount = order.getTotalOrderPrice() * specialDiscount/100;
			registeredCustomerTotalOrderPrice += order.getTotalOrderPrice() - discount;
		}
		
		return registeredCustomerTotalOrderPrice;
	}

	@Override
	public String toString() {
		return "RegisteredCustomer [specialDiscount=" + specialDiscount + ", customerName=" + customerName + ", orders="
				+ orders + "]";
	}
}
