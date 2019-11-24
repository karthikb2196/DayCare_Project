package edu.neu.csye6200.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.neu.csye6200.model.ClassRoom;
import edu.neu.csye6200.model.ClassRoomRule;
import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.model.ImmunizationRecord;
import edu.neu.csye6200.model.Person;
import edu.neu.csye6200.model.Student;


public class DayCareCompany {

	private List<Person> teachers = new ArrayList<>();
	private List<Person> students = new ArrayList<>();
	private List<ImmunizationRecord> immunizationDirectory = new ArrayList<ImmunizationRecord>();
	private List<ClassRoomRule> classRuleSet = new ArrayList<ClassRoomRule>();
	private List<ClassRoom> classRooms = new ArrayList<ClassRoom>();
	private List<Immunization> immunizations = new ArrayList<>();//a list of all immunizations we have right now
	private int numberOfClassrooms;
	
	
	
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
	
//	public List<ClassRoom> getClassRoomList(Person s){
//		List<ClassRoom> classRooms = new ArrayList<ClassRoom>();
//		for(ClassRoom c : this.getClassRooms()) {
//			if(s.getAge() <= c.getA() && s.getAge() >= c.getMaxStudents())
//		}
//	}
//	
	public void addStudent(Person s) {
		this.getStudents().add(s);
		
		for(ClassRoom classRoom : this.getClassRooms()) {
			int addStudent= classRoom.addStudent(s);
			if(addStudent < classRoom.getMaxStudents() && addStudent> 0) {
				System.out.println("Student added to classroom: "+classRoom.getClassRoomID());
			}
		}
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
	
	public List<ClassRoomRule> getClassRuleSet() {
		return classRuleSet;
	}
	public void setClassRuleSet(ClassRoomRule classRule) {
		classRuleSet.add(classRule);
	}
	
	
		
	@Override
	public String toString() {
		return "DayCareCompany [teachers=" + teachers + ", students=" + students + ", immunizationDirectory="
				+ immunizationDirectory + ", classRuleSet=" + classRuleSet + ", classRooms=" + classRooms
				+ ", immunizations=" + immunizations + "]";
	}
//	public void show() {
//		
//	}
	
	public static void demo() {
		DayCareCompany dayCareCompany = new DayCareCompany();
		
		ClassRoomRule rule1 = new ClassRoomRule(1,"Classroom for ages 6-12", 12, 6, 0.25,4, 12,3);
		ClassRoomRule rule2 = new ClassRoomRule(2,"Classroom for ages 13-24", 24, 13, 0.20,5, 15,3);
		ClassRoomRule rule3 = new ClassRoomRule(3,"Classroom for ages 25-35", 35, 25, 0.20,6, 18,3);
		ClassRoomRule rule4 = new ClassRoomRule(4,"Classroom for ages 36-47", 47, 36, 0.20,8, 24,3);
		ClassRoomRule rule5 = new ClassRoomRule(5,"Classroom for ages 48-59", 59, 48, 0.20,12, 24,2);
		ClassRoomRule rule6 = new ClassRoomRule(6,"Classroom for ages 60 and above", 24,60, 0.20,15,30,2);
		dayCareCompany.setClassRuleSet(rule1);
		dayCareCompany.setClassRuleSet(rule2);
		dayCareCompany.setClassRuleSet(rule3);
		dayCareCompany.setClassRuleSet(rule4);
		dayCareCompany.setClassRuleSet(rule5);
		dayCareCompany.setClassRuleSet(rule6);
		
		ClassRoom classRoom1 = new ClassRoom(1,1,rule1);
		ClassRoom classRoom2 = new ClassRoom(2,2,rule2);
		ClassRoom classRoom3 = new ClassRoom(3,3,rule3);
	
		
		dayCareCompany.addClassRoom(classRoom1);
		dayCareCompany.addClassRoom(classRoom2);
		dayCareCompany.addClassRoom(classRoom3);
		
		Student student1 = new Student(1,"bsvg","vcgveg",7,new Date(),"GG","JJ");
		Student student2 = new Student("25,jim,hello,26,10-22-2019,john,JJ");
		
//		for(ClassRoom classRoom : dayCareCompany.getClassRooms()) {
//			classRoom.addStudent(student1);
////			classRoom.addStudent(student2);
//		}
		dayCareCompany.addStudent(student1);
		dayCareCompany.addStudent(student2);
//		dayCareCompany.toString();
		
		
	}
	
}
