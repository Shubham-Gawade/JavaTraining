package com.xoriant.companyorderapp.entities;

public class OrderItem {
	private int quantity;
	private Item item;
	
	public OrderItem() {
	
	}

	public OrderItem(int quantity, Item item) {
		this.quantity = quantity;
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public double getTotalOrderItemPrice() {
		return quantity*item.getItemPrice();
	}

	@Override
	public String toString() {
		return "OrderItem [quantity=" + quantity + ", item=" + item + "]";
	}
}
