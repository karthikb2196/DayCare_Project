package edu.neu.csye6200.model;

public class DTaP_Rule extends ImmunizationRule {
	public DTaP_Rule(int ruleID, String ruleDescription, int ageUpperLimit, int ageLowerLimit, String immunization,
			int requiredAmt, int duration) {
		super(ruleID, ruleDescription, ageUpperLimit, ageLowerLimit, immunization, requiredAmt, duration);
		// TODO Auto-generated constructor stub
	}
	
	public DTaP_Rule(String csv) {
		super(csv);
	}
}
