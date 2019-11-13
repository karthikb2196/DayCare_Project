package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

	private int classRoomID;
	private List<Teacher> teachers = new ArrayList<>();
	private List<Student> students = new ArrayList<>();
	private float classRatio;
	private int maxStudents;
	private int maxTeachers;
	private List<ClassRoomRule> classRoomRule;
	
	public int getClassRoomID() {
		return classRoomID;
	}
	public void setClassRoomID(int classRoomID) {
		this.classRoomID = classRoomID;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
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
	

	
}
