package com.xoriant.companyorderapp.entities;

import java.util.*;

public class Customer {
	protected String customerName;
	protected List<Order> orders=new ArrayList<>();
	
	public Customer(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
	public double getCustomerTotalOrderPrice() {
		double customerTotalOrderPrice = 0;
		for(Order order:orders) {
			customerTotalOrderPrice += order.getTotalOrderPrice();
		}
		
		return customerTotalOrderPrice;
	}
	
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", orders=" + orders + "]";
	}

}
