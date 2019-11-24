package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

	private int classRoomID;
	private List<Person> teachers = new ArrayList<>(); //list of teacher id
	private List<Person> students = new ArrayList<>(); //list of student id
	private float classRatio;
	private int maxStudents;
	private int maxTeachers;
	private List<ClassRoomRule> classRoomRule = new ArrayList<>();
	private int numberOfStudents;
	
	public ClassRoom(int classRoomID) {
		this.classRoomID = classRoomID;
	}
	public int getClassRoomID() {
		return classRoomID;
	}
	public void setClassRoomID(int classRoomID) {
		this.classRoomID = classRoomID;
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
	
	public void addTeacher(Person t) {
		this.teachers.add(t);
	}

	
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	
	//Check if the classroom is full or not, and check the ratio for the student
	public boolean CheckClassroom(Person person) {
		if(this.getNumberOfStudents() < this.getMaxStudents()) {
			for(ClassRoomRule classRoomRule : classRoomRule) {
			if((person.getAge() <= classRoomRule.getAgeUpperLimit()) && (person.getAge() >= classRoomRule.getAgeUpperLimit())) {
				return true;
			}
		}
	}
			return false;	
		}
		
	public String addStudent(Person person) {
		boolean check = CheckClassroom(person);
		if(check == true) {
				this.students.add(person);
				return "Sucess! Student added to class" + classRoomID;
			}
		return "Failed! Student not added to this class" ;
		}
}
