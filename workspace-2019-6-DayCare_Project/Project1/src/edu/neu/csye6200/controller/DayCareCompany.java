package edu.neu.csye6200.controller;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.model.ClassRoom;
import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.model.ImmunizationRecord;
import edu.neu.csye6200.model.Person;
import edu.neu.csye6200.model.Rule;


public class DayCareCompany {

	private List<Person> teachers = new ArrayList<>();
	private List<Person> students = new ArrayList<>();
	private List<ImmunizationRecord> immunizationDirectory = new ArrayList<ImmunizationRecord>();
	private List<ClassRoom> classRooms = new ArrayList<ClassRoom>();
	private List<Immunization> immunizations = new ArrayList<>();//a list of all immunizations
	private List<Rule> immunizationRules = new ArrayList<>();//a list of all immunization rules 
	
	
	public List<Immunization> getImmunizations() {
		return immunizations;
	}
	public void setImmunizations(List<Immunization> immunizations) {
		this.immunizations = immunizations;
	}
	public List<Person> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Person> teachers) {
		this.teachers = teachers;
	}
	public List<Person> getStudents() {
		return students;
	}
	public void setStudents(List<Person> students) {
		this.students = students;
	}
	public List<ImmunizationRecord> getImmunizationDirectory() {
		return immunizationDirectory;
	}
	public void setImmunizationDirectory(List<ImmunizationRecord> immunizationDirectory) {
		this.immunizationDirectory = immunizationDirectory;
	}
	public List<ClassRoom> getClassRooms() {
		return classRooms;
	}
	public void setClassRooms(List<ClassRoom> classRooms) {
		this.classRooms = classRooms;
	}
	
	public void addStudent(Person s) {
		this.students.add(s);
	}
		
	public void addTeacher(Person s) {
		this.teachers.add(s);
	}
	
	public void addImmunization(Immunization i) {
		this.immunizations.add(i);
	}
	
	public void addClassRoom(ClassRoom c) {
		this.getClassRooms().add(c);
	}
	
	public List<Rule> getImmunizationRules() {
		return immunizationRules;
	}
	public void setImmunizationRules(List<Rule> immunizationRules) {
		this.immunizationRules = immunizationRules;
	}
	public void addRule(Rule r) {
		this.immunizationRules.add(r);
	}
}
