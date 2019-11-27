package edu.neu.csye6200.model;

import java.util.Date;

public class PolioImmunization extends Immunization{

	private String polioVaccine = "Polio Immunization"; 

	public PolioImmunization(int immunizationID, String immunizationName, int ageReceived, Date dateReceived) {
		super(immunizationID, immunizationName, ageReceived, dateReceived);
		this.setImmunizationName(polioVaccine);
	}



}
