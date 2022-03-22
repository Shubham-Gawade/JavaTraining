package com.assessmentmanageapp.entities;

import java.util.*;

public class TrainingModel {
	private String clientName;
	private List<Iteration> iterations=new ArrayList<>();
	
    public TrainingModel() {
    }
    
    public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public void addIteration(Iteration iteration) {
		this.iterations.add(iteration);
	}


    public int getTotalAssessmentsInTheTraining() {
    	int totalAssessment=0;
    	for(Iteration iteration:iterations) {
    		int directAssessmentCount = iteration.getAssessments().size();
    		if(iteration.getCourse() != null ) {	
    			int courseAssessmentCount = iteration.getCourse().getAssessments().size();
	    		totalAssessment += courseAssessmentCount+directAssessmentCount;
    		}
    		else {
	    		totalAssessment += directAssessmentCount;
    		}
    	}
        return totalAssessment;
    }

   
    public int getNumMCQBasedAssessments() {
    	int totalMCQAssessment=0;
    	for(Iteration iteration:iterations) {
    		Assessment assessment=new Assessment();
    		List<Assessment> directAssessments=iteration.getAssessments();
    		
    		if(iteration.getCourse() != null ) {
    			List<Assessment> courseAssessments=iteration.getCourse().getAssessments();
	    		totalMCQAssessment += assessment.getMCQCount(courseAssessments) + assessment.getMCQCount(directAssessments);
    		}
    		else {
    			totalMCQAssessment += assessment.getMCQCount(directAssessments);
    		}
    	}
        return totalMCQAssessment;
    }

    
    public int getNumHandsOnBasedAssessments() {
    	int totalHandsOnAssessment=0;
    	for(Iteration iteration:iterations) {
    		Assessment assessment=new Assessment();
    		List<Assessment> directAssessments=iteration.getAssessments();
    		
    		if(iteration.getCourse() != null ) {
        		List<Assessment> courseAssessments=iteration.getCourse().getAssessments();
	    		totalHandsOnAssessment += assessment.getHandsOnCount(courseAssessments) + assessment.getHandsOnCount(directAssessments);
    		}
    		else {
	    		totalHandsOnAssessment += assessment.getHandsOnCount(directAssessments);
    		}
    	}
        return totalHandsOnAssessment;
    }

  
    public int getTotalScoreOfAllAssessments() {
    	int totalScoreOfAllAssessments = 0;
    	for(Iteration iteration:iterations) {
    		List<Assessment> directAssessments=iteration.getAssessments();
    		if(iteration.getCourse() != null ) {	
    			List<Assessment> courseAssessments=iteration.getCourse().getAssessments();
    			
	    		for(Assessment assessment: courseAssessments) {
	    			totalScoreOfAllAssessments += assessment.getMarksOfAssesment(assessment.getQuestions());
	    		}	
	    		for(Assessment assessment: directAssessments) {
	    			totalScoreOfAllAssessments += assessment.getMarksOfAssesment(assessment.getQuestions());
	    		}
    		}
    		else {
    			for(Assessment assessment: directAssessments) {
	    			totalScoreOfAllAssessments += assessment.getMarksOfAssesment(assessment.getQuestions());
	    		}
    		}
    	}
        return totalScoreOfAllAssessments;
    }    
}