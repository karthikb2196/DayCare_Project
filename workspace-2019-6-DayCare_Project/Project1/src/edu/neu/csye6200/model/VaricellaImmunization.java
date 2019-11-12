package edu.neu.csye6200.model;

import java.util.Date;

public class VaricellaImmunization extends Immunization {

	private String varicellaVaccine = "Varicella Immunization"; 
	public VaricellaImmunization(int ageReceived, Date dateReceived) {
		this.setImmunizationName(varicellaVaccine);
		this.setAgeReceived(ageReceived);
		this.setDateReceived(dateReceived);
		this.setRule(new Rule());
		// TODO Auto-generated constructor stub
	}


	@Override
	public void CheckImmunization() {
		// TODO Auto-generated method stub
		
	}

}
