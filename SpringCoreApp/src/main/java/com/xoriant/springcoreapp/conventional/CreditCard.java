package com.xoriant.springcoreapp.conventional;

public interface CreditCard {
	
	void transaction(double amount);
	boolean authorization();
}
