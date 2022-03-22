package com.xoriant.hibernateapp.model;

import javax.persistence.Entity;

@Entity
public class SavingAccount extends Account {

	private double minBalance;

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
}
