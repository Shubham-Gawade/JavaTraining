package com.trainingmanagementapp.entities;

import java.util.ArrayList;
import java.util.List;

public class Training extends Trainer{
	
	private Trainer trainer;
	private Course course;
	private List<Trainee> trainees = new ArrayList<>();
	private List<Training> trainings = new ArrayList<>();
	
	public Training() {
		super();
	}
	
	public void addTraining(Training t) {
		trainings.add(t);
	}
	
	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Trainee> getTrainees() {
		return trainees;
	}
	public void setTrainees(List<Trainee> trainees) {

		this.trainees = trainees;
	}

	public Training(Trainer trainer, Course course, List<Trainee> trainees) {
		super();
		this.trainer = trainer;
		this.course = course;
		this.trainees = trainees;
	}
	
	public int getNumOfTrainees() {
		return this.trainees.size();
	}
	public String getTrainingOrganisationName() {
		return this.trainer.getOrganisationName();
	}
	public int getTrainingDurationHours() {
		return this.course.getCourseDuration();
	}
	
	public void showTopisOfEachUnit(Course course) {

		List<Module> modules=course.getModules();
		for(Module module:modules) {
			List<Unit> units=module.getUnits();
			System.out.println(module.getModuleName()+" : ");
			for(Unit unit:units) {
				System.out.print(unit.getUnitName()+" : ");
				List<Topic> topics=unit.getTopics();
				for(Topic topic:topics) {
					System.out.print(topic.getName()+", ");
				}
				System.out.println();
			}
			System.out.println("----------------------------------------");
		}
	}
}
