package edu.neu.csye6200.model;

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
	public Immunization getImmunization() {
		// TODO Auto-generated method stub
		return null;
	}

}
