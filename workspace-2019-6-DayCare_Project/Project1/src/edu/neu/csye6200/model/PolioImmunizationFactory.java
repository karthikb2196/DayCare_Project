package edu.neu.csye6200.model;

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
	public Immunization getImmunization() {
		// TODO Auto-generated method stub
		return null;
	}

}
