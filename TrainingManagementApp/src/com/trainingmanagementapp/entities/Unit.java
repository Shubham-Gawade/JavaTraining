package com.trainingmanagementapp.entities;

import java.util.*;

public class Unit {
	private String UnitName;
	private int durationHours;
	private List<Topic> topics = new ArrayList<>();
	
	public Unit() {
		super();
	}

	public Unit(String unitName, int durationHours) {
		super();
		UnitName = unitName;
		this.durationHours = durationHours;
	}

	public String getUnitName() {
		return UnitName;
	}

	public void setUnitName(String unitName) {
		UnitName = unitName;
	}

	public int getDurationHours() {
		return durationHours;
	}

	public void setDurationHours(int durationHours) {
		this.durationHours = durationHours;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public void addTopic(Topic t) {
		this.topics.add(t);
	}
}
