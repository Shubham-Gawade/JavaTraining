package com.xoriant.springcoreapp.conventional;

public class CreditCardICICI implements CreditCard
{
	private double balance;
	
	public CreditCardICICI(double balance) {
		super();
		this.balance = balance;
	}

	public void transaction(double amount) {
		double charges = amount * 0.05;
		balance = balance - (amount + charges);
		System.out.println(toString());
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "CreditCardICICI [balance=" + balance + "]";
	}

	public boolean authorization() {
		System.out.println("The Card details are valid");
		return true;
	}
}
