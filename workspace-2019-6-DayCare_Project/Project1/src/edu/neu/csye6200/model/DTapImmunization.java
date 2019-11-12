package edu.neu.csye6200.model;

import java.util.Date;

public class DTapImmunization extends Immunization {
	private String dtapVaccine = "DTaP Immunization"; 
	public DTapImmunization(int ageReceived, Date dateReceived) {
		this.setImmunizationName(dtapVaccine);
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
