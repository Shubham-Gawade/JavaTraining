package com.xoriant.companyorderapp.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static com.xoriant.companyorderapp.entities.TestData.*;

@RunWith(JUnitPlatform.class)
public class OrderItemTest{
	
	private static OrderItem orderItem;
	
	
	@BeforeAll
	public static void initOnce() {
		orderItem= new OrderItem();
		orderItem.setItem(getItem());
		orderItem.setQuantity(4);
		System.out.println("BeforeAll called once");
	}
	
	@BeforeEach
	public void init() {
		System.out.println("Init Called");
	}
	

	@Test
	void testGetTotalOrderItemPriceFirst() {
		//assertArrayEquals(null, null);
		//assertEquals(80000, orderItem.getTotalOrderItemPrice());
		assertThrows(ArithmeticException.class, ()->{orderItem.getTotalOrderItemPrice();} );
	}
	
	@Test
	@Disabled
	void testGetTotalOrderItemPriceSecond() {
		assertAll(
				()->assertEquals(80000, orderItem.getTotalOrderItemPrice()),
				()->assertEquals(80000, orderItem.getTotalOrderItemPrice()));
	}
	
	@AfterEach
	void destroy() {
		System.out.println("Tear Down");
	}
	
	@AfterAll
	public static void destroyOnce() {
		orderItem=null;
		System.out.println("AfterAll called once");
	}
}
