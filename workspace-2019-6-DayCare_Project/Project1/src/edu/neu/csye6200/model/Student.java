package edu.neu.csye6200.model;

import java.util.Date;

public class Student extends Person implements Comparable<Student> {

	private String fatherName;
	private String motherName;

	// This constructor should only be used for initialization
	public Student(int id, String firstName, String lastName, 
			int age, String FatherName, String MotherName,Date dateOfEnrollment) {
		super(id, firstName, lastName, age,dateOfEnrollment);
		fatherName = FatherName;
		motherName = MotherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

		@Override
	public String toString() {
		return "Student [studentId=" + this.getId() + ", fatherName=" + fatherName + ", motherName=" + motherName + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return Integer.valueOf(this.getId() ).compareTo(o.getId() );
	}
}

