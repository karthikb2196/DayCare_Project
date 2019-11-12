package edu.neu.csye6200.model;

import java.util.Date;

public class HibImmunization extends Immunization {

	private String hibVaccine = "HIB Immunization"; 
	public HibImmunization(int ageReceived, Date dateReceived) {
		this.setImmunizationName(hibVaccine);
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
