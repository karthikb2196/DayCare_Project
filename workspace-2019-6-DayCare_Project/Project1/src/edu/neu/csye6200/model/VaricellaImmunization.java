package edu.neu.csye6200.model;

import java.util.Date;

public class VaricellaImmunization extends Immunization {

	private String varicellaVaccine = "Varicella Immunization"; 


	public VaricellaImmunization(int immunizationID, String immunizationName, int ageReceived, Date dateReceived) {
		super(immunizationID, immunizationName, ageReceived, dateReceived);
		this.setImmunizationName(varicellaVaccine);
	}

}
