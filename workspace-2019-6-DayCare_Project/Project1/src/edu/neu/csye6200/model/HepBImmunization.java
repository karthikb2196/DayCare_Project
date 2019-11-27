package edu.neu.csye6200.model;

import java.util.Date;

public class HepBImmunization extends Immunization{
   private final String NAME = "Hepatitis B Vaccine";

	public HepBImmunization(int immunizationID, String immunizationName, int ageReceived, Date dateReceived) {
		super(immunizationID, immunizationName, ageReceived, dateReceived);
		this.setImmunizationName(NAME);
	}


}
