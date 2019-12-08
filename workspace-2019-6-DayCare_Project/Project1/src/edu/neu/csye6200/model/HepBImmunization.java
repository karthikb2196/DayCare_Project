package edu.neu.csye6200.model;

import java.util.Date;

public class HepBImmunization extends Immunization{
   private final static String NAME = "Hepatitis B Vaccine";
   private final static int immunizationID = 2;

	public HepBImmunization( int ageReceived, Date dateReceived) {
		super(immunizationID, NAME, ageReceived, dateReceived);
	}


}
