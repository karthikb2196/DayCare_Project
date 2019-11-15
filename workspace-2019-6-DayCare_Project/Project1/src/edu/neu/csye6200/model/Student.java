package edu.neu.csye6200.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	
	public Student(String[] info) throws NumberFormatException, ParseException {
		//create a student by a line in csv
		super(Integer.parseInt(info[0]), 
				info[1], info[2], 
				Integer.parseInt(info[3]),
				new SimpleDateFormat("MM-dd-yyyy").parse(info[4]));
		fatherName = info[5];
		motherName = info[6];
		
	}

	public Student(String csvData) {
		super();
		try {
			String[] args = csvData.split(",");
			 int id = Integer.parseInt(args[0]);
			 String firstName = args[1];
			 String lastName = args[2];
			 int age = Integer.parseInt(args[3]);
			 Date dateOfEnrollment = null;
			 dateOfEnrollment = ft.parse(args[4]);
			 String fatherName = args[5];
			 String motherName = args[6];
			 
			 this.setId(id);
			 this.setFirstName(firstName);
			 this.setLastName(lastName);
			 this.setAge(age);
			 this.setDateOfEnrollment(dateOfEnrollment);
			 this.setImmunizationRecord(new ImmunizationRecord(id));
			 this.setFatherName(fatherName);
			 this.setMotherName(motherName);
			 
			}
			catch(Exception e) {
				e.printStackTrace();
			}
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

	public String output() {
	return this.getId() + " " + this.getStudentId() + " " + this.getFirstName() + " " + this.getLastName() + " "
			+ this.getAge() + " " + this.getClass() + " " + this.getFatherName() + " " + this.getMotherName() + " "
			+ this.getImmunizationRecord();

	}
//	@Override
//	public String toString() {
//		return "Student [studentId=" + studentId + "firstName=" + firstName + ", fatherName=" + fatherName + ", motherName=" + motherName + "]";
//	}


	private int getStudentId() {
		// TODO Auto-generated method stub
		return this.getId();
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return Integer.valueOf(this.getId() ).compareTo(o.getId() );
	}
}

