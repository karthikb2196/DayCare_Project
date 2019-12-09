package edu.neu.csye6200.model;

import java.util.Date;

public class PolioImmunization extends Immunization{

	private static String NAME = "Polio Immunization"; 
	/*
	 * 	ImmunizationRule DTap_rule1 = new ImmunizationRule(1,12,29,"DTap",4);
		ImmunizationRule polio_rule1 = new ImmunizationRule(2,12,29,"Polio",3);
		ImmunizationRule hepB_rule1 = new ImmunizationRule(3,12,29,"HepB",3);
		ImmunizationRule mmr_rule1 = new ImmunizationRule(4,12,29,"MMR",1);
		ImmunizationRule hib_rule1 = new ImmunizationRule(5,12,29,"Hib",4);
		ImmunizationRule v1 = new ImmunizationRule(6,12,29,"Varicella",1);
	 */

	public PolioImmunization( int ageReceived, Date dateReceived) {
		super(2, NAME, ageReceived, dateReceived);
	}



}
