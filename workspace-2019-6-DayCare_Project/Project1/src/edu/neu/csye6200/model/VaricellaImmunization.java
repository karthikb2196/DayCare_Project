package edu.neu.csye6200.model;

import java.util.Date;

public class VaricellaImmunization extends Immunization {

	private static String NAME = "Varicella Immunization"; 


	public VaricellaImmunization(int ageReceived, Date dateReceived) {
		super(6, NAME, ageReceived, dateReceived);
	}

}
