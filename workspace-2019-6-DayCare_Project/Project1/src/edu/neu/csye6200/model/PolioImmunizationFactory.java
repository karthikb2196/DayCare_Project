package edu.neu.csye6200.model;

import java.util.Date;

public class PolioImmunizationFactory extends AbstractImmunizationFactory {

	private static PolioImmunizationFactory polioImmunizationFactory=null;

	private PolioImmunizationFactory() {
		polioImmunizationFactory = null;
	}

	public PolioImmunizationFactory getInstance() {
		polioImmunizationFactory = new PolioImmunizationFactory();
		return polioImmunizationFactory;
	}

	@Override
	public Immunization getImmunization(int id, String name, int age, Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
