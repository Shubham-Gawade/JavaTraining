package com.assessmentmanageapp.entities;

public class HandsOnQuestion extends Question {
    public HandsOnQuestion() {
    }


    private String questionDesc;
    private String referenceDocument;
    
	public HandsOnQuestion(String questionDesc, String referenceDocument, int marks) {
		super();
		this.questionDesc = questionDesc;
		this.referenceDocument = referenceDocument;
		this.marks=marks;
	}
	public String getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}
	public String getReferenceDocument() {
		return referenceDocument;
	}
	public void setReferenceDocument(String referenceDocument) {
		this.referenceDocument = referenceDocument;
	}
	
	public int getMarks() {
    	return this.marks;
    }

}