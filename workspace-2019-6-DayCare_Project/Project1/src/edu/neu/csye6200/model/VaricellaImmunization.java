package edu.neu.csye6200.model;

import java.util.Date;

public class VaricellaImmunization extends Immunization {

	private String varicellaVaccine = "Varicella Immunization"; 
	public VaricellaImmunization(int ageReceived, Date dateReceived,int numberOfDosesGiven) {
		this.setImmunizationName(varicellaVaccine);
		this.setAgeReceived(ageReceived);
		this.setDateReceived(dateReceived);
	//	this.setRule(new Rule()); // should be PolioRule
		this.setNumberOfDosesGiven(numberOfDosesGiven);
		// TODO Auto-generated constructor stub
	}


}
