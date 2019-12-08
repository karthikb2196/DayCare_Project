package edu.neu.csye6200.model;

import java.util.Date;

public class MMRImmunization extends Immunization {

	private final static String NAME = "MMR Immunization";
	private final static int immunizationID = 3;

	public MMRImmunization(int ageReceived, Date dateReceived) {
		super(immunizationID, NAME, ageReceived, dateReceived);
	}

}
