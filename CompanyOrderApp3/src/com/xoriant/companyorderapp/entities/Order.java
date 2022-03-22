package com.xoriant.companyorderapp.entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int orderId;
	private List<OrderItem> orderItems=new ArrayList<>();
	
	public Order(){
		
	}
	public Order(int orderId) {
		this.orderId = orderId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void addOrderItem(OrderItem orderItem) {
		this.orderItems.add(orderItem);
	}
	
	public double getTotalOrderPrice() {
		double totalOrderPrice = 0;
		for(OrderItem orderItem: orderItems) {
			totalOrderPrice += orderItem.getTotalOrderItemPrice();
		}
		
		return totalOrderPrice;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderItems=" + orderItems + "]";
	}
}
