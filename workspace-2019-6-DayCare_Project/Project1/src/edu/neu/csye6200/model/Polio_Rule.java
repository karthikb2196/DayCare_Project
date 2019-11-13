package edu.neu.csye6200.model;

public class Polio_Rule extends ImmunizationRule {
	public Polio_Rule(int ruleID, String ruleDescription, int ageUpperLimit, int ageLowerLimit, String immunization,
			int requiredAmt, int duration) {
		super(ruleID, ruleDescription, ageUpperLimit, ageLowerLimit, immunization, requiredAmt, duration);
		// TODO Auto-generated constructor stub
	}
	
	public Polio_Rule(String csv) {
		super(csv);
	}
}
