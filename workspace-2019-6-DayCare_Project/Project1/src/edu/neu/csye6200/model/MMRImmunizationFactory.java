package edu.neu.csye6200.model;

import java.util.Date;

public class MMRImmunizationFactory extends AbstractImmunizationFactory{
	private static MMRImmunizationFactory mmrImmunizationFactory=null;

	private MMRImmunizationFactory() {
		mmrImmunizationFactory = null;
	}

	public MMRImmunizationFactory getInstance() {
		mmrImmunizationFactory = new MMRImmunizationFactory();
		return mmrImmunizationFactory;
	}

	@Override
	public Immunization getImmunization(int id, String name, int age, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
