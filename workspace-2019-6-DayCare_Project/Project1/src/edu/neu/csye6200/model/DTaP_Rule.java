package edu.neu.csye6200.model;

public class DTaP_Rule extends ImmunizationRule {
	
	

	public DTaP_Rule(int ruleID, int ageLowerLimit, int ageUpperLimit, String immunization, int requiredAmt,
			int duration) {
		super(ruleID, ageLowerLimit, ageUpperLimit, immunization, requiredAmt, duration);
		// TODO Auto-generated constructor stub
	}

	public DTaP_Rule(String rule) {
		super(rule);
		// TODO Auto-generated constructor stub
	}

	
	
}
