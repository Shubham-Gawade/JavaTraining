package com.xoriant.springcoreapp.conventional;

public class CreditCardService {
	private CreditCard creditCard;
	
	//CreditCardService is dependent on CreditCard(Which type of CreditCard)
	//Dependency Injection
	
	//Constructor Injection
	public CreditCardService(CreditCard creditCard) {
		this.creditCard=creditCard;
	}
	
	//Setter Injection
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard=creditCard;
	}
	
	public void initiateTransaction(double amount) {
		if(creditCard.authorization()) {
			creditCard.transaction(amount);
		}
	}
}
