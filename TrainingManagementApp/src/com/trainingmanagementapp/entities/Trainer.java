package com.trainingmanagementapp.entities;

import java.util.ArrayList;
import java.util.List;

public class Trainer{
	
	private String trainerName;
	private Organisation organisation;
	private List<Training> trainings =new ArrayList<>();
	
	public Trainer() {
		super();
	}
	public Trainer(String trainerName, String name) {
		super();
		this.trainerName = trainerName;
		this.organisation = new Organisation(name);
	}
	public Trainer(String trainerName, Organisation name) {
		super();
		this.trainerName = trainerName;
		this.organisation = name;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getOrganisationName() {
		return organisation.getOrganisationName();
	}
	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}
	public void setOrganisation(String name) {
		this.organisation = new Organisation(name);
	}
}
