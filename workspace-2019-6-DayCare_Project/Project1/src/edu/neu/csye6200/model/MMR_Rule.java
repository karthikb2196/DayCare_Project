package edu.neu.csye6200.model;

public class MMR_Rule extends ImmunizationRule {

	public MMR_Rule(int ruleID, String ruleDescription, int ageUpperLimit, int ageLowerLimit, String immunization,
			int requiredAmt, int duration) {
		super(ruleID, "MMR Rule", ageUpperLimit, ageLowerLimit, immunization, requiredAmt, duration);
	}

	public MMR_Rule(String csv_rule) {
		super(csv_rule);
	}

}
