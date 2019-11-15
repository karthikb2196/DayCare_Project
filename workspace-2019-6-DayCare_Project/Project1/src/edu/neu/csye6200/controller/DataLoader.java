package edu.neu.csye6200.controller;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.model.Person;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;

public class DataLoader {
	
	private DayCareCompany company;
	private final String studentCSV ="students.csv";
	private final String teacherCSV="teachers.csv";
	private  final String recordCSV="record.csv"; 
	private  final String classroomCSV="classroom.csv"; 
	
	public DataLoader(DayCareCompany company) {
		this.company=company;
	}
	
	public List<String> readFile(String csv) throws FileNotFoundException {
/*
 * read a csv file and return a list of strings
 * each element is a line 
 */
		List<String> strings = new ArrayList<String>();
		Scanner inLine = new Scanner(new BufferedReader(new FileReader(csv)));
		while (inLine.hasNextLine()) {
			strings.add(inLine.nextLine());
		}
		inLine.close();
		return strings;
	}
	
	public void readStudents() throws FileNotFoundException, NumberFormatException, ParseException {
		/* read the students.csv
		 * create and load all Student objects into the company
		 */
		List<String> students = readFile(studentCSV);
		for(String student:students) {
			String[] info = student.split(",");
			this.company.addStudent(new Student(info));
		}
	}
	
//	########Will work on this part once decide the teachers.csv format
//	public void readTeachers() throws FileNotFoundException, NumberFormatException, ParseException {
//		/* read the teachers.csv
//		 * create and load all Teacher objects into the company
//		 */
//		List<String> teachers = readFile(teacherCSV);
//		for(String t:teachers) {
//			String[] info = t.split(",");
//			this.company.addTeacher(new Teacher(info));
//		}
//	}
	
	public void readRecord() throws FileNotFoundException, NumberFormatException, ParseException {
		/* read record.csv
		 * load all record to each person's immunizationRecord
		 */
		List<String> records = readFile(recordCSV);
		for(String record:records) {
			String[] info = record.split(",");
			int person_id = Integer.parseInt(info[0]);
			int immu_id = Integer.parseInt(info[1]);
			for(Person person:this.company.getStudents()) {
				// find the person
				if(person_id==person.getId()) {
					// create an immunization object
					Immunization i = new Immunization(immu_id,
												     info[2], 
													Integer.parseInt(info[3]),
													new SimpleDateFormat("dd/MM/yyyy").parse(info[4]),
													Integer.parseInt(info[5]));
					//add the immunization object to the person's record 
					person.getImmunizationRecord().AddImmunization(i);
				}
			}
		}
	}
	
	
	

}
