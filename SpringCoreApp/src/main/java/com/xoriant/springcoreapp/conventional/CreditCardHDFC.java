package com.xoriant.springcoreapp.conventional;

public class CreditCardHDFC implements CreditCard
{
	private double balance;
	
	public CreditCardHDFC(double balance) {
		super();
		this.balance = balance;
	}

	public void transaction(double amount) {
		double charges = amount * 0.03;
		balance = balance - (amount + charges);
		System.out.println(toString());
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "CreditCardHDFC [balance=" + balance + "]";
	}

	public boolean authorization() {
		System.out.println("The Card details are valid");
		return true;
	}
}
