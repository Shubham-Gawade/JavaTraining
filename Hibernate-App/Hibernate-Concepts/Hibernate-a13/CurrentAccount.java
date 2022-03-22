package com.xoriant.hibernateapp.model;

import javax.persistence.Entity;

@Entity
public class CurrentAccount extends Account {

	private int dailyLimit;

	public int getDailyLimit() {
		return dailyLimit;
	}

	public void setDailyLimit(int dailyLimit) {
		this.dailyLimit = dailyLimit;
	}
}
