package edu.neu.csye6200.model;

import java.util.Date;

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
	public Immunization getImmunization(int id, String name, int age, Date date) {
		// TODO Auto-generated method stub
		return null;
	}


}
