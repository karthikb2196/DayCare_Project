package edu.neu.csye6200.model;

import java.util.Date;

public class DTapImmunization extends Immunization {
	private final static String dtapVaccine = "DTaP";
	private final static int immunizationID = 1;
	
	
	public DTapImmunization(int ageReceived, Date dateReceived) {
		super(immunizationID, dtapVaccine, ageReceived, dateReceived);
	}
	
	


}
