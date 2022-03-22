package com.xoriant.companyorderapp.view;

import com.xoriant.companyorderapp.entities.Company;
import com.xoriant.companyorderapp.entities.Customer;
import com.xoriant.companyorderapp.entities.Item;
import com.xoriant.companyorderapp.entities.Order;
import com.xoriant.companyorderapp.entities.OrderItem;
import com.xoriant.companyorderapp.entities.RegisteredCustomer;

public class TestMain {

	public static void main(String[] args) {
		//1. Create set of Items
		Item item1=new Item("Samsung TV",20000);
		Item item2=new Item("HP Laptop",35000);
		Item item3=new Item("Vivo Smart Phone",25000);
		Item item4=new Item("Head Phone",1500);
		Item item5=new Item("Smart Watch",4000);
		Item item6=new Item("PS5",50000);
		
		//2. Create set of OrderItems
		OrderItem orderItem1=new OrderItem(2,item1);
		OrderItem orderItem2=new OrderItem(4,item2);
		OrderItem orderItem3=new OrderItem(3,item3);
		OrderItem orderItem4=new OrderItem(5,item4);
		OrderItem orderItem5=new OrderItem(2,item5);
		OrderItem orderItem6=new OrderItem(2,item6);
		
		//3. Create set of Orders
		Order order1=new Order(111);
		order1.addOrderItem(orderItem1);
		order1.addOrderItem(orderItem2);
		
		Order order2=new Order(112);
		order2.addOrderItem(orderItem2);
		order2.addOrderItem(orderItem3);
		
		Order order3=new Order(113);
		order3.addOrderItem(orderItem3);
		order3.addOrderItem(orderItem4);
		
		Order order4=new Order(114);
		order4.addOrderItem(orderItem4);
		order4.addOrderItem(orderItem5);
		
		Order order5=new Order(115);
		order5.addOrderItem(orderItem5);
		order5.addOrderItem(orderItem6);
		
		Order order6=new Order(116);
		order6.addOrderItem(orderItem1);
		order6.addOrderItem(orderItem6);
		
		//4. Create set of Customers
		Customer customer1=new Customer("Mayank");
		customer1.addOrder(order1);
		customer1.addOrder(order2);
		
		Customer customer2=new Customer("Pranav");
		customer2.addOrder(order3);
		customer2.addOrder(order4);
		
		RegisteredCustomer customer3=new RegisteredCustomer("Shubham");
		customer3.addOrder(order5);
		customer3.addOrder(order6);
		customer3.setSpecialDiscount(30);
		
		//5. Create set of RegisteredCustomers
		Company company=new Company("Xoriant");
		company.addCustomer(customer1);
		company.addCustomer(customer2);
		company.addCustomer(customer3);
		
		//6. Write the logic to calculate total worth of sale
		System.out.println("Total Worth Of Sale is "+company.getTotalWorthOfSale());
	}

}
