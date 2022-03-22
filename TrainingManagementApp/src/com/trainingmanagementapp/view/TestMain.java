package com.trainingmanagementapp.view;

import com.trainingmanagementapp.entities.Topic;
import com.trainingmanagementapp.entities.Training;
import com.trainingmanagementapp.entities.Module;
import com.trainingmanagementapp.entities.Organisation;
import com.trainingmanagementapp.entities.Unit;
import com.trainingmanagementapp.entities.Trainer;
import com.trainingmanagementapp.entities.Trainee;

import java.util.ArrayList;
import java.util.List;

import com.trainingmanagementapp.entities.Course;

public class TestMain {

	public static void main(String[] args) {
		
		Topic topic1=new Topic("Inheritance");
		Topic topic2=new Topic("Polymorphism");
		Topic topic3=new Topic("Encapsulation");
		Topic topic4=new Topic("Abstraction");
		
		Topic topic5=new Topic("Pointer");
		Topic topic6=new Topic("Friend Function");
		Topic topic7=new Topic("Virtual Function");

		Topic topic8=new Topic("List");
		Topic topic9=new Topic("Set");
		
		
		Unit unit1=new Unit("Unit 1",10);
		unit1.addTopic(topic1);
		unit1.addTopic(topic2);
		unit1.addTopic(topic3);
		unit1.addTopic(topic4);
		
		Unit unit2=new Unit("Unit 2",8);
		unit2.addTopic(topic5);
		unit2.addTopic(topic6);
		unit2.addTopic(topic7);
		
		Unit unit3=new Unit("Unit 3",6);
		unit3.addTopic(topic8);
		unit3.addTopic(topic9);
		
		Unit unit4=new Unit("Unit 4",12);
		unit4.addTopic(topic1);
		unit4.addTopic(topic5);
		unit4.addTopic(topic8);
		
		Module module1=new Module("Module 1");
		module1.addUnit(unit1);
		module1.addUnit(unit2);
		
		Module module2=new Module("Module 2");
		module2.addUnit(unit3);
		module2.addUnit(unit4);
		
		Course course=new Course("Programming");
		course.addModule(module1);
		course.addModule(module2);
		
		Organisation organisation = new Organisation("Xoriant Solutions");
		Trainer trainer = new Trainer("Saheer",organisation);
		
		Trainee t1 = new Trainee("Trainee1");
		Trainee t2 = new Trainee("Trainee2");
		Trainee t3 = new Trainee("Trainee3");
		
		List<Trainee> traineeList =  new ArrayList<>();
		traineeList.add(t1);
		traineeList.add(t2);
		traineeList.add(t3);
		
		Training training = new Training();
		training.setCourse(course);
		training.setTrainer(trainer);
		training.setTrainees(traineeList);
		
		System.out.println("Training Organization Name : "+training.getTrainingOrganisationName());
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Number Of Trainees : "+training.getNumOfTrainees());
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Total Training Duration is : "+training.getTrainingDurationHours());
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Course Wise Topics Are : ");
		training.showTopisOfEachUnit(course);
		System.out.println("-----------------------------------------------------------------");
	}

}
