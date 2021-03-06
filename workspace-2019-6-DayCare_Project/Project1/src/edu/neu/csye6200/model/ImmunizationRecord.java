package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.List;

public class ImmunizationRecord {

private int studentId;
private List<Immunization> immunizationList = new ArrayList<>();
private String toGet = new String();


public ImmunizationRecord(int studentId) {
	super();
	this.studentId = studentId;
	this.immunizationList = new ArrayList<>();
}

public int getStudentId() {
	return studentId;
}

public void setStudentId(int studentId) {
	this.studentId = studentId;
}

public List<Immunization> getImmunizationList() {
	return immunizationList;
}
public void setImmunizationList(List<Immunization> immunizationList) {
	this.immunizationList = immunizationList;
}


public String getToGet() {
	return toGet;
}

public void setToGet(String toGet) {
	this.toGet = toGet;
}

public void AddImmunization(Immunization immunization) {
	immunizationList.add(immunization);
	System.out.println(immunization.getImmunizationName()+" added to student "+this.studentId);
}
public void RemoveImmunization(Immunization immunization) {
	immunizationList.remove(immunization);
	System.out.println("Immunization "+immunization.getImmunizationName()+"removed from the list");
}

public void ClearAll() {
	immunizationList.clear();
	System.out.println("Removing all immunizations from record");
}

@Override
public String toString() {
	this.getImmunizationList().forEach(System.out::println);
	return "";
}

public int doseTaken(int immu_id) {
	//count how many doses are taken
	int count=0;
	for(Immunization i:this.getImmunizationList()) {
		if(i.getImmunizationID()==immu_id) {
			count+=1;
		}
	}
	return count;
}
public void UpdateImmunization(Immunization immunization) {
	
}









}
