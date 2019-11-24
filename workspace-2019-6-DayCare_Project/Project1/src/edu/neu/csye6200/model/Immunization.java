package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Immunization {

	private int immunizationID;
	private String immunizationName;
	private int ageReceived;
	private List<ImmunizationRule> rules=new ArrayList<>(); 
	/*
Each immunization has a list of rules
To decide the immunization requirement, go through all the 
ImmunizationRule objects in the list
	*/
	private Date dateReceived;
	private int numberOfDosesGiven;
	
	public Immunization(int immunizationID, String immunizationName, int ageReceived, 
			Date dateReceived, int numberOfDosesGiven) {
		super();
		this.immunizationID = immunizationID;
		this.immunizationName = immunizationName;
		this.ageReceived = ageReceived;
		this.dateReceived = dateReceived;
		this.numberOfDosesGiven = numberOfDosesGiven;
	}

	public int getImmunizationID() {
		return immunizationID;
	}

	public void setImmunizationID(int immunizationID) {
		this.immunizationID = immunizationID;
	}

	public String getImmunizationName() {
		return immunizationName;
	}

	public void setImmunizationName(String immunizationName) {
		this.immunizationName = immunizationName;
	}

	public int getAgeReceived() {
		return ageReceived;
	}

	public void setAgeReceived(int ageReceived) {
		this.ageReceived = ageReceived;
	}

	public List<ImmunizationRule> getRule() {
		return this.rules;
	}

	public void addRule(ImmunizationRule rule) {
		this.rules.add(rule);
	}

	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public int getNumberOfDosesGiven() {
		return numberOfDosesGiven;
	}

	public void setNumberOfDosesGiven(int numberOfDosesGiven) {
		this.numberOfDosesGiven = numberOfDosesGiven;
	}


}
