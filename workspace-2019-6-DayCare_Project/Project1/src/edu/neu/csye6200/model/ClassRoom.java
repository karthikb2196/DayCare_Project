package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

	private int classRoomID;
	private int ruleID;
	private List<Person> teachers = new ArrayList<>(); //list of teacher id
	private List<Person> students = new ArrayList<>(); //list of student id
	private float classRatio;
	private int groupSize;
	private int maxStudents;
	private int maxTeachers; // also number of groups
	private ClassRoomRule classRoomRule;
	private int numberOfStudents=0;
	private int numberOfTeachers=0;
	private int numberOfGroups = 0;

	public ClassRoom(int classRoomID) {
		this.classRoomID = classRoomID;
	}
	// To create a classRoom based on a specific rule
	public ClassRoom(int classRoomID, int ruleID,ClassRoomRule classRoomrule) {
		this.classRoomID=classRoomID;
		this.ruleID = ruleID;
		this.classRoomRule=classRoomrule;
		this.maxStudents = classRoomRule.getMaxStudents();
		this.maxTeachers = classRoomRule.getMaxTeachers();
		this.groupSize=classRoomRule.getGroupSize();
		this.numberOfGroups = this.maxTeachers; 
	}
	
	public int getClassRoomID() {
		return classRoomID;
	}
	public void setClassRoomID(int classRoomID) {
		this.classRoomID = classRoomID;
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
	public ClassRoomRule getClassRoomRule() {
		return classRoomRule;
	}
	public void setClassRoomRule(ClassRoomRule classRoomRule) {
		this.classRoomRule = classRoomRule;
	}
	public int getRuleID() {
		return ruleID;
	}
	public void setRuleID(int ruleID) {
		this.ruleID = ruleID;
	}
	public float getClassRatio() {
		return classRatio;
	}
	public void setClassRatio(float classRatio) {
		this.classRatio = classRatio;
	}
	public int getMaxStudents() {
		return maxStudents;
	}
	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}
	public int getMaxTeachers() {
		return maxTeachers;
	}
	public void setMaxTeachers(int maxTeachers) {
		this.maxTeachers = maxTeachers;
	}
	
	public int getGroupSize() {
		return groupSize;
	}
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	public void addTeacher(Person t) {
		this.teachers.add(t);
	}

	
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	

	public int getNumberOfTeachers() {
		return numberOfTeachers;
	}
	public void setNumberOfTeachers(int numberOfTeachers) {
		this.numberOfTeachers = numberOfTeachers;
	}
	public int getNumberOfGroups() {
		return numberOfGroups;
	}
	public void setNumberOfGroups(int numberOfGroups) {
		this.numberOfGroups = numberOfGroups;
	}
	@Override
	public String toString() {
		return "ClassRoom [classRoomID=" + classRoomID + ", ruleID=" + ruleID + ", teachers=" + teachers + ", students="
				+ students + ", classRatio=" + classRatio + ", maxStudents=" + maxStudents + ", maxTeachers="
				+ maxTeachers + ", classRoomRule=" + classRoomRule + ", numberOfStudents=" + numberOfStudents + "]";
	}
	
	//Check if the classroom is full or not, and check the ratio for the student
	public boolean CheckClassroom(Person student) {
		if(this.getNumberOfStudents() <= classRoomRule.getMaxStudents()) {	
			if((student.getAge() <= classRoomRule.getAgeUpperLimit()) && (student.getAge() >= classRoomRule.getAgeLowerLimit())) {
				return true;
		}
	}
		return false;
	}
	
	//Adding student 
	public int addStudent(Person student) {
		boolean check = CheckClassroom(student);
		if(check == true) {
				this.students.add(student);
				numberOfStudents+=1;
//				System.out.println("Number of Students:"+ numberOfStudents);
//				System.out.println("Maximum number of students: "+this.getMaxStudents());
				return numberOfStudents;
			}
		if(numberOfStudents > this.getMaxStudents()) {
			return -1;
		}
		else {
			System.out.println("Failed! Student not added as the student did not meet the credentials for this class");
			return -2;
		}
		
		}
	
	//Checking teacher eligibility
	
	
	//adding teacher
	public int addTeacher(Teacher teacher) {
		if(this.numberOfTeachers<this.maxTeachers) {
			teacher.setIdle(false);
			this.setTeachertoClass(teacher);
			numberOfTeachers+=1;
			return numberOfTeachers;
		}
		else {
			return -1;
		}
		
	}
	public void setTeachertoClass(Teacher teacher) {
		this.getTeachers().add(teacher);
		
	}
	
}