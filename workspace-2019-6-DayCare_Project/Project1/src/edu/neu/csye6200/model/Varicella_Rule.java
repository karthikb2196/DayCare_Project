package edu.neu.csye6200.model;

public class Varicella_Rule extends ImmunizationRule {

	public Varicella_Rule(int ruleID, String ruleDescription, int ageUpperLimit, int ageLowerLimit, String immunization,
			int requiredAmt, int duration) {
		super(ruleID, ruleDescription, ageUpperLimit, ageLowerLimit, immunization, requiredAmt, duration);
		// TODO Auto-generated constructor stub
	}

	public Varicella_Rule(String csv_rule) {
		super(csv_rule);
		// TODO Auto-generated constructor stub
	}

}
