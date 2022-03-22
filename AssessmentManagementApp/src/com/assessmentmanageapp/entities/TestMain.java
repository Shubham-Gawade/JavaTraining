package com.assessmentmanageapp.entities;


public class TestMain {

	public static void main(String[] args) 
	{
		MCQQuestion mcqQuestion1=new MCQQuestion("Sun rises from?","east","west","north","south","east",1);
		MCQQuestion mcqQuestion2=new MCQQuestion("Sun sets in the?","east","west","north","south","west",1);
		MCQQuestion mcqQuestion3=new MCQQuestion("Largest Mammal?","elephant","rhino","giraffe","cow","elephant",1);
		MCQQuestion mcqQuestion4=new MCQQuestion("Right Angle is ?","30","60","90","180","90",1);
		
		HandsOnQuestion handsOnQuestion1=new HandsOnQuestion("Write a code for prime number.","PrimeNumber.java",5);
		HandsOnQuestion handsOnQuestion2=new HandsOnQuestion("Write a code for perfect number.","PerfectNumber.java",5);
		
		Assessment assessment1=new Assessment(101,"General Knowledge",3,"9-8-2021");
		assessment1.addQuestion(mcqQuestion1);
		assessment1.addQuestion(mcqQuestion2);
		
		Assessment assessment2=new Assessment(102,"Maths",3,"9-9-2021");
		assessment2.addQuestion(mcqQuestion3);
		assessment2.addQuestion(mcqQuestion4);
		
		Assessment assessment3=new Assessment(103,"Programming 1",1,"10-9-2021");
		assessment3.addQuestion(handsOnQuestion1);
		
		Assessment assessment4=new Assessment(104,"Programming 2",1,"10-9-2021");
		assessment4.addQuestion(handsOnQuestion2);
		
		Assessment assessment5=new Assessment(105,"Aptitude",3,"10-9-2021");
		assessment5.addQuestion(mcqQuestion1);
		assessment5.addQuestion(mcqQuestion3);
		
		Course course1=new Course("10","Course For Beginner");
		course1.addAssessment(assessment1); //M   
		course1.addAssessment(assessment2); //M   
		course1.addAssessment(assessment3); //H   
		
		Course course2=new Course("11","Course For Advanced");
		course2.addAssessment(assessment3); //H   
		course2.addAssessment(assessment4); //H   
		course2.addAssessment(assessment5); //M   
		
		Iteration iteration1=new Iteration();
		iteration1.setCourse(course1);         //3
		iteration1.addAssessment(assessment1); //1  M
		iteration1.addAssessment(assessment2); //1  M
		iteration1.addAssessment(assessment3); //1  H   
		
		Iteration iteration2=new Iteration();
		iteration2.setCourse(course2);         //3
		iteration2.addAssessment(assessment3); //1  H
		iteration2.addAssessment(assessment4); //1  H
		iteration2.addAssessment(assessment5); //1  M   
		
		Iteration iteration3=new Iteration();
		iteration3.addAssessment(assessment1); //1  M
		iteration3.addAssessment(assessment2); //1  M
		iteration3.addAssessment(assessment3); //1  H   

		
		TrainingModel model=new TrainingModel();
		model.addIteration(iteration1);
		model.addIteration(iteration2);
		model.addIteration(iteration3);
		
		System.out.println("Total Number of Assessment in Training : "+model.getTotalAssessmentsInTheTraining()); //15
		System.out.println("Total Number of MCQ Assessment in Training : "+model.getNumMCQBasedAssessments());   //8
		System.out.println("Total Number of  Hands On Assessment in Training : "+model.getNumHandsOnBasedAssessments()); //7
		System.out.println("Total Score Of All Assessments : "+model.getTotalScoreOfAllAssessments());  
	}

}