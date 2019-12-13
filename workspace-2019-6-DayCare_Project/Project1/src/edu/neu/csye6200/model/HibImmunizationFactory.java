package edu.neu.csye6200.model;

import java.util.Date;

public class HibImmunizationFactory extends AbstractImmunizationFactory {
private static HibImmunizationFactory hibImmunizationFactory=null;

private HibImmunizationFactory() {
	hibImmunizationFactory = null;
}

public HibImmunizationFactory getInstance() {
	hibImmunizationFactory = new HibImmunizationFactory();
	return hibImmunizationFactory;
}


@Override
public Immunization getImmunization(int id, String name, int age, Date date) {
	// TODO Auto-generated method stub
	return null;
}


}