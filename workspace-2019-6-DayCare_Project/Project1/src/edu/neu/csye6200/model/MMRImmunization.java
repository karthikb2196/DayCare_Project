package edu.neu.csye6200.model;

import java.util.Date;

public class MMRImmunization extends Immunization {

	private String mmrVaccine = "MMR Immunization";

	public MMRImmunization(int ageReceived, Date dateReceived, int numberOfDosesGiven) {
		this.setImmunizationName(mmrVaccine);
		this.setAgeReceived(ageReceived);
		this.setDateReceived(dateReceived);
		this.setNumberOfDosesGiven(numberOfDosesGiven);
	}

}
