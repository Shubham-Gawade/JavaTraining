package com.xoriant.companyorderapp.entities;

import java.util.*;

public class Company {
	private String companyName;
	private List<Customer> customers=new ArrayList<>();
	private List<Item> items=new ArrayList<>();
	
	public Company() {
		super();
	}

	public Company(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}
	public List<Item> getItems() {
		return items;
	}
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public double getTotalWorthOfSale() {
		//Code to calculate TotalWorthOfSale
		double totalWorthOfSale=0;
		for(Customer customer: customers) {  // 3 Customers 
			for(Order order: customer.orders) {
				for(OrderItem orderItem: order.getOrderItems()) {
					double salePrice = orderItem.getQuantity()*orderItem.getItem().getItemPrice();
					if(customer instanceof RegisteredCustomer) {
						RegisteredCustomer registeredCustomer=(RegisteredCustomer)customer;
						double discount =(registeredCustomer.getSpecialDiscount()*salePrice)/100;
						salePrice=salePrice-discount;
					}
					totalWorthOfSale+=salePrice;
				}
			}
		}
		return totalWorthOfSale;
	}
	
	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", customers=" + customers + ", items=" + items + "]";
	}
	
}
