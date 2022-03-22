package com.assessmentmanageapp.entities;

import java.util.*;

public class Course {

    public Course() {
    }
    
    private String courseId;
    private String name;
    private List<Assessment> assessments=new ArrayList<Assessment>();
    
	public Course(String courseId, String name) {
		super();
		this.courseId = courseId;
		this.name = name;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Assessment> getAssessments() {
		return assessments;
	}
	
	public void addAssessment(Assessment assessment) {
		this.assessments.add(assessment);
	}

}