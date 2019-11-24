package edu.neu.csye6200.model;

public class ImmunizationRule implements Rule {
	
	private int ruleID;
	private int ageLowerLimit;
	private int ageUpperLimit;
	private String ruleDescription;
	private int requiredAmt; //how many doses are required
	private int duration;
	
	
	public ImmunizationRule(int ruleID, int ageLowerLimit, int ageUpperLimit, String immunization, int requiredAmt,
			int duration) {
		this.ruleID = ruleID;
		this.ageLowerLimit = ageLowerLimit;
		this.ageUpperLimit = ageUpperLimit;
		this.ruleDescription = immunization;
		this.requiredAmt = requiredAmt;
		this.duration = duration;
	}
	
	public ImmunizationRule(String rule) {
		/*
		 * create based on a csv row. 
		 * Format: "ImmuID, ageLowerLimit, ageUpperLimit, immunization,requiredAmt,duration"
		 */
		String[] info = rule.split(",");
		this.ruleID = Integer.parseInt(info[0]);
		this.ageLowerLimit = Integer.parseInt(info[1]);
		this.ageUpperLimit = Integer.parseInt(info[2]);
		this.ruleDescription = info[3];
		this.requiredAmt = Integer.parseInt(info[4]);
		this.duration = Integer.parseInt(info[5]);
	}
	
	public int getRuleID() {
		return ruleID;
	}
	public void setRuleID(int ruleID) {
		this.ruleID = ruleID;
	}
	public int getAgeLowerLimit() {
		return ageLowerLimit;
	}
	public void setAgeLowerLimit(int ageLowerLimit) {
		this.ageLowerLimit = ageLowerLimit;
	}
	public int getAgeUpperLimit() {
		return ageUpperLimit;
	}
	public void setAgeUpperLimit(int ageUpperLimit) {
		this.ageUpperLimit = ageUpperLimit;
	}
	public String getImmunization() {
		return ruleDescription;
	}
	public void setImmunization(String immunization) {
		this.ruleDescription = immunization;
	}
	public int getRequiredAmt() {
		return requiredAmt;
	}
	public void setRequiredAmt(int requiredAmt) {
		this.requiredAmt = requiredAmt;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String getRuleDescription() {
		// TODO Auto-generated method stub
		return this.ruleDescription;
	}

	@Override
	public void setRuleDescription(String descr) {
		this.ruleDescription=descr;
		
	} 

	


}
