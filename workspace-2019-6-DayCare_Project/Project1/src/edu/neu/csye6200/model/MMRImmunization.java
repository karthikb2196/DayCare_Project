package edu.neu.csye6200.model;

import java.util.Date;

public class MMRImmunization extends Immunization {

	private String mmrVaccine = "HIB Immunization"; 
	public MMRImmunization(int ageReceived, Date dateReceived) {
		this.setImmunizationName(mmrVaccine);
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
