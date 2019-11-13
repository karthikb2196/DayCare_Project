package edu.neu.csye6200.model;

public class DTapImmunizationFactory extends AbstractImmunizationFactory {

	private static DTapImmunizationFactory dtapImmunizationFactory=null;

	private DTapImmunizationFactory() {
		dtapImmunizationFactory = null;
	}

	public DTapImmunizationFactory getInstance() {
		dtapImmunizationFactory = new DTapImmunizationFactory();
		return dtapImmunizationFactory;
	}
	
	@Override
	public Immunization getImmunization() {
		// TODO Auto-generated method stub
		return null;
	}

}
