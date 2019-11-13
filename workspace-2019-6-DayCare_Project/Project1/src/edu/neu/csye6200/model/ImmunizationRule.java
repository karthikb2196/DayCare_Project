package edu.neu.csye6200.model;

public class ImmunizationRule implements Rule {
	
	private int ruleID;
	private String ruleDescription;
	private int ageUpperLimit;
	private int ageLowerLimit;
	private String immunization;
	private int requiredAmt; //how many doses are required
	private int duration; 

	public ImmunizationRule(int ruleID,String ruleDescription, int ageUpperLimit, int ageLowerLimit, String immunization,
			int requiredAmt, int duration) {
		super();
		this.ruleID=ruleID;
		this.ruleDescription = ruleDescription;
		this.ageUpperLimit = ageUpperLimit;
		this.ageLowerLimit = ageLowerLimit;
		this.immunization = immunization;
		this.requiredAmt = requiredAmt;
		this.duration = duration;
	}
	
	public ImmunizationRule(String csv_rule) {
		/* Read a CSV file and create the Rule object
		String rule = read file here
		String[] rule_data = rule.split(",");
		Then initialize the rule
		*/
		this.ruleDescription = ruleDescription;
		this.ageUpperLimit = ageUpperLimit;
		this.ageLowerLimit = ageLowerLimit;
		this.immunization = immunization;
		this.requiredAmt = requiredAmt;
		this.duration = duration;
	}
	


	public int getRuleID() {
		return ruleID;
	}

	public void setRuleID(int ruleID) {
		this.ruleID = ruleID;
	}

	public int getAgeUpperLimit() {
		return ageUpperLimit;
	}

	public void setAgeUpperLimit(int ageUpperLimit) {
		this.ageUpperLimit = ageUpperLimit;
	}

	public int getAgeLowerLimit() {
		return ageLowerLimit;
	}

	public void setAgeLowerLimit(int ageLowerLimit) {
		this.ageLowerLimit = ageLowerLimit;
	}

	public String getImmunization() {
		return immunization;
	}

	public void setImmunization(String immunization) {
		this.immunization = immunization;
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
