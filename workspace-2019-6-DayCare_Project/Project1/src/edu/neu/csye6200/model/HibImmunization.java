package edu.neu.csye6200.model;

import java.util.Date;

public class HibImmunization extends Immunization {

	private final String NAME = "HIB Immunization"; 

	public HibImmunization(int immunizationID, String immunizationName, int ageReceived, Date dateReceived,
			int numberOfDosesGiven) {
		super(immunizationID, immunizationName, ageReceived, dateReceived, numberOfDosesGiven);
		this.setImmunizationName(NAME);
	}


}
