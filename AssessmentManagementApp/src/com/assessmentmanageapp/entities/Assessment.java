package com.assessmentmanageapp.entities;

import java.util.*;

public class Assessment {

    public Assessment() {
    }

    private int assessmentId;
    private String desc;
    private int noQuestions;
    private String dtAssessment;
    private List<Question> questions=new ArrayList<Question>();

    public Assessment(int assessmentId, String desc, int noQuestions, String dtAssessment) {
		super();
		this.assessmentId = assessmentId;
		this.desc = desc;
		this.noQuestions = noQuestions;
		this.dtAssessment = dtAssessment;
	}


	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getNoQuestions() {
		return noQuestions;
	}

	public void setNoQuestions(int noQuestions) {
		this.noQuestions = noQuestions;
	}

	public String getDtAssessment() {
		return dtAssessment;
	}

	public void setDtAssessment(String dtAssessment) {
		this.dtAssessment = dtAssessment;
	}

	public List<Question> getQuestions() {
		return questions;
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}

	public int getMCQCount(List<Assessment> assessments) {
		int countMCQAssessment = 0;
		for(Assessment assessment : assessments) {
			List<Question> questions= assessment.getQuestions();
			if(questions.get(0) instanceof MCQQuestion) {
				countMCQAssessment++;
			}
		}
		return countMCQAssessment;
	}
	
	public int getHandsOnCount(List<Assessment> assessments) {
		int countHandsOnAssessment = 0;
		for(Assessment assessment : assessments) {
			List<Question> questions= assessment.getQuestions();
			if(questions.get(0) instanceof HandsOnQuestion) {
				countHandsOnAssessment++;
			}
		}
		return countHandsOnAssessment;
	}
	
	public int getMarksOfAssesment(List<Question> questions) {
		int countMarks = 0;
		for(Question question: questions) {
			countMarks += question.getMarks();
		}
		return countMarks;
	}
	
	public int getTotalMarks() {
       
        return 0;
    }

}