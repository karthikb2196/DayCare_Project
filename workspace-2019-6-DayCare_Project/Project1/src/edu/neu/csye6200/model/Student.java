package edu.neu.csye6200.model;

public class Student extends Person implements Comparable<Student> {

	private int studentId;// primary key for student, automatically increased by 1, start from 100001,
							// cannot be set manually
	private String fatherName;
	private String motherName;

	// This constructor should only be used for initialization
	public Student(int id, String firstName, String lastName, int age, String FatherName, String MotherName,
			ImmunizationRecord immunizationRecord, int StudentId) {
		super(id, firstName, lastName, age);
		studentId = StudentId;
		fatherName = FatherName;
		motherName = MotherName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
		return "Student [studentId=" + studentId + ", fatherName=" + fatherName + ", motherName=" + motherName
				+ ", getId()=" + getId() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getAge()=" + getAge() + ", getImmunizationRecord()=" + getImmunizationRecord() + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return Integer.valueOf(studentId).compareTo(o.studentId);
	}
}


}
