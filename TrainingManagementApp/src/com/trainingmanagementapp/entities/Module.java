package com.trainingmanagementapp.entities;

import java.util.ArrayList;
import java.util.List;

public class Module {
	private String moduleName;
	private List<Unit> units = new ArrayList<>();
	
	public Module() {
		super();
	}
	public Module(String moduleName) {
		super();
		this.moduleName = moduleName;
	}
	public Module(String moduleName, List<Unit> units) {
		super();
		this.moduleName = moduleName;
		this.units = units;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public List<Unit> getUnits() {
		return units;
	}
	public void setUnits(List<Unit> units) {
		this.units = units;
	}
	public void addUnit(Unit u) {
		this.units.add(u);
	}
	public int getModuleDuration() {
		int duration = 0;
		for( Unit u :units) {
			duration += u.getDurationHours();
		}
		return duration;
	}
	
}
