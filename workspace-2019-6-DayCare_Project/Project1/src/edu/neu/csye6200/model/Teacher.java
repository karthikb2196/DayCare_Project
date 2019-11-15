package edu.neu.csye6200.model;

import java.util.Date;

public class Teacher extends Person implements Comparable<Teacher> {

	public Teacher(int id, String firstName, String lastName, int age, Date dateOfEnrollment) {
		super(id, firstName, lastName, age, dateOfEnrollment);
		// TODO Auto-generated constructor stub
	}

	private int teacherId;// automatically increased by 1, start at 1001
	private boolean isIdle = true;// mark whether the teacher is ready for classes or not, true means can be
									// arranged. If all teachers are not idle
	private int stateLevel;// the level this teacher is available to teach. 1 means 6-12month, etc.
	private Date registerTime;

//	public Teacher(int teacherId, String firstName, String lastName, Date registerTime, int stateLevel, int age,
//			int id) {
//		super(id, firstName, lastName, age);
//		this.teacherId = teacherId;
//		this.registerTime = registerTime;
//		this.stateLevel = stateLevel;
//	}

//	public Teacher(String[] info) {
//		//create Teacher object based on a line in teachers.csv
//		
//	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public boolean isIdle() {
		return isIdle;
	}

	public void setIdle(boolean isIdle) {
		this.isIdle = isIdle;
	}

	public int getStateLevel() {
		return stateLevel;
	}

	public void setStateLevel(int stateLevel) {
		this.stateLevel = stateLevel;
	}

	public String output() {
		return this.getId() + "  " + this.getTeacherId() + " " + this.getFirstName() + " " + this.getLastName() + " "
				+ this.getStateLevel() + this.getAge() + " " + this.getClass() + " " + this.getImmunizationRecord();

	}
//	@Override
//	public String toString() {
//		return "Teacher [teacherId=" + teacherId + ", isIdle=" + isIdle + ", stateLevel=" + stateLevel
//				+ ", registerTime=" + registerTime + "]";
//	}

	@Override
	public int compareTo(Teacher tch) {
		// TODO Auto-generated method stub
		return Integer.valueOf(teacherId).compareTo(tch.teacherId);
	}

}
