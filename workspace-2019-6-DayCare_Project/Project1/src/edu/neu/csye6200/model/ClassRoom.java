package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

	private int classRoomID;
	private List<Integer> teachers = new ArrayList<>(); //list of teacher id
	private List<Integer> students = new ArrayList<>(); //list of student id
	private float classRatio;
	private int maxStudents;
	private int maxTeachers;
	private List<ClassRoomRule> classRoomRule = new ArrayList<>();
	
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
	
	public void addStudent(int s) {
		this.students.add(s);
	}
	
	public void addTeacher(int t) {
		this.teachers.add(t);
	}

	
}
