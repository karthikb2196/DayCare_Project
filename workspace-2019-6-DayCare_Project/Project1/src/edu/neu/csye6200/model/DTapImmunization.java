package edu.neu.csye6200.model;

import java.util.Date;

public class DTapImmunization extends Immunization {
	private final String dtapVaccine = "DTaP Immunization";
	
	public DTapImmunization(int immunizationID, String immunizationName, int ageReceived, Date dateReceived,
			int numberOfDosesGiven) {
		super(immunizationID, immunizationName, ageReceived, dateReceived, numberOfDosesGiven);
		this.setImmunizationName(dtapVaccine);
	}
	
	


}
