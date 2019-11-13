package edu.neu.csye6200.model;

public class VaricellaImmunizationFactory extends AbstractImmunizationFactory {

	private static VaricellaImmunizationFactory varicellaImmunizationFactory=null;

	private VaricellaImmunizationFactory() {
		varicellaImmunizationFactory = null;
	}

	public VaricellaImmunizationFactory getInstance() {
		varicellaImmunizationFactory = new VaricellaImmunizationFactory();
		return varicellaImmunizationFactory;
	}
	
	@Override
	public Immunization getImmunization() {
		// TODO Auto-generated method stub
		return null;
	}

}
