package edu.neu.csye6200.model;

import java.util.Date;

public class MMRImmunization extends Immunization {

	private final String NAME = "MMR Immunization";


	public MMRImmunization(int immunizationID, String immunizationName, int ageReceived, Date dateReceived,
			int numberOfDosesGiven) {
		super(immunizationID, immunizationName, ageReceived, dateReceived, numberOfDosesGiven);
		this.setImmunizationName(NAME);
	}

}
