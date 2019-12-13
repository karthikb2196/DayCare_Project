package edu.neu.csye6200.model;

import java.util.Date;

public abstract class AbstractImmunizationFactory {

	public abstract Immunization getImmunization(int id,String name,int age,Date date);
	
}
