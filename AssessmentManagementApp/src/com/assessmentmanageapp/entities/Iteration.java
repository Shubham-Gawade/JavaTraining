package com.assessmentmanageapp.entities;

import java.util.*;

public class Iteration {
	
    public Iteration() {
    }

    private int iterationNo;
    private String goal;
    private Course course;
    private List<Assessment> assessments=new ArrayList<Assessment>();
    
	public Iteration(int iterationNo, String goal) {
		super();
		this.iterationNo = iterationNo;
		this.goal = goal;
	}
	public int getIterationNo() {
		return iterationNo;
	}
	public void setIterationNo(int iterationNo) {
		this.iterationNo = iterationNo;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Assessment> getAssessments() {
		return assessments;
	}
	
	public void addAssessment(Assessment assessment) {
		this.assessments.add(assessment);
	}
}