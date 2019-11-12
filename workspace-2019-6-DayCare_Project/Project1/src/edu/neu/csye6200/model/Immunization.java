package edu.neu.csye6200.model;

import java.util.Date;

public abstract class Immunization {
	
	private String immunizationName;
	private int ageReceived;
	private Rule rule;
	private Date dateReceived;
	

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
	public Rule getRule() {
		return rule;
	}
	public void setRule(Rule rule) {
		this.rule = rule;
	}
	public Date getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}
	
	public abstract void CheckImmunization();
}
