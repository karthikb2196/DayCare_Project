package edu.neu.csye6200.model;

public class HepBImmunizationFactory extends AbstractImmunizationFactory {
	private static HepBImmunizationFactory hepBImmunizationFactory=null;

	private HepBImmunizationFactory() {
		hepBImmunizationFactory = null;
	}

	public HepBImmunizationFactory getInstance() {
		hepBImmunizationFactory = new HepBImmunizationFactory();
		return hepBImmunizationFactory;
	}
	@Override
	public Immunization getImmunization() {
		// TODO Auto-generated method stub
		return null;
	}

}
