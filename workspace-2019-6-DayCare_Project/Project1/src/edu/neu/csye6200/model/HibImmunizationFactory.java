package edu.neu.csye6200.model;

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
public Immunization getImmunization() {
	// TODO Auto-generated method stub
	return null;
}


}