package edu.neu.csye6200.model;

import java.util.Date;

public class DTapImmunization extends Immunization {
	private String dtapVaccine = "DTaP Immunization";
	
	
	public DTapImmunization(int ageReceived, Date dateReceived,int numberOfDosesGiven) {
		this.setImmunizationName(dtapVaccine);
		this.setAgeReceived(ageReceived);
		this.setDateReceived(dateReceived);
		this.setNumberOfDosesGiven(numberOfDosesGiven);
		this.setRule(new Rule()); // should be DTapRule
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void CheckImmunization() {
		// TODO Auto-generated method stub
		
	}

}
