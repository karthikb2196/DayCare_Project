package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Immunization {

	private int immunizationID;
	private String immunizationName;
	private int ageReceived;
	/*
Each immunization has a list of rules
To decide the immunization requirement, go through all the 
ImmunizationRule objects in the list
	*/
	private Date dateReceived;
	
	public Immunization(int immunizationID, String immunizationName, int ageReceived, 
			Date dateReceived) {
		super();
		this.immunizationID = immunizationID;
		this.immunizationName = immunizationName;
		this.ageReceived = ageReceived;
		this.dateReceived = dateReceived;
	}

	public int getImmunizationID() {
		return immunizationID;
	}

	public void setImmunizationID(int immunizationID) {
		this.immunizationID = immunizationID;
	}

	public String getImmunizationName() {
		return immunizationName;
	}

	public void setImmunizationName(String immunizationName) {
		this.immunizationName = immunizationName;
	}

	public int getAgeReceived() {
		return ageReceived;
	}

	public void setAgeReceived(int ageReceived) {
		this.ageReceived = ageReceived;
	}


	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}


}
