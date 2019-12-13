package edu.neu.csye6200.model;
import java.util.Date;

import edu.neu.csye6200.model.AbstractImmunizationFactory;
import edu.neu.csye6200.model.Immunization;

public class ImmunizationFactory extends AbstractImmunizationFactory{
	
	private static ImmunizationFactory immunizationFactory = null;
	
	private ImmunizationFactory() {
		// TODO Auto-generated constructor stub
		this.immunizationFactory=null;
	}
	
	public static ImmunizationFactory getInstance() {
		return immunizationFactory=new ImmunizationFactory();
	}
	
	@Override
	public Immunization getImmunization(int id, String name, int age, Date date) {
		// TODO Auto-generated method stub
		return new Immunization(id, name, age, date);
	}

}
