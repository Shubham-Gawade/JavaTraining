package com.trainingmanagementapp.entities;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String courseName;
	private List<Module> modules = new ArrayList<>();
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	public int getCourseDuration() {
		int duration = 0;
		for( Module m :modules) {
			duration += m.getModuleDuration() ;
		}
		return duration;
	}
	
	public void addModule(Module m) {
		this.modules.add(m);
	}
	
}
