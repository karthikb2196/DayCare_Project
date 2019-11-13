package edu.neu.csye6200.model;

import java.util.Date;

public class HepBImmunization extends Immunization{
   private String hepBVaccine = "Hepatitis B Vaccine";
	public HepBImmunization(int ageReceived, Date dateReceived,int numberOfDosesGiven) {
		this.setImmunizationName(hepBVaccine);
		this.setAgeReceived(ageReceived);
		this.setDateReceived(dateReceived);
	//	this.setRule(new Rule()); // should be HepBRule
		this.setNumberOfDosesGiven(numberOfDosesGiven);
		// TODO Auto-generated constructor stub
	}


}
