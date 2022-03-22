package com.xoriant.springcoreapp.conventional;

public class TestMain {

	public static void main(String[] args) {

		CreditCardHDFC customer1 = new CreditCardHDFC(10000);
		CreditCardICICI customer2 = new CreditCardICICI(10000);
		CreditCardAxis customer3 = new CreditCardAxis(10000);
	
		CreditCardService service1=new CreditCardService(customer1);
		CreditCardService service2=new CreditCardService(customer2);
		CreditCardService service3=new CreditCardService(customer3);
	
		service1.initiateTransaction(5000);
		service2.initiateTransaction(5000);
		service3.initiateTransaction(5000);
	}
}
