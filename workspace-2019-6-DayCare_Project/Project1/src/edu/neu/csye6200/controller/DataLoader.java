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

import edu.neu.csye6200.model.ClassRoom;
import edu.neu.csye6200.model.ClassRoomRule;
import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.model.ImmunizationRule;
import edu.neu.csye6200.model.Person;
import edu.neu.csye6200.model.Rule;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;

public class DataLoader {

	private DayCareCompany company;
	private final String studentCSV = "students.csv";
	private final String teacherCSV = "teachers.csv";
	private final String recordCSV = "records.csv";
	private final String classroomCSV = "classrooms.txt";
	private final String ImmunizationRuleCSV = "ImmunizationRules.csv";
	public static int studentIds = 0;

	public DataLoader(DayCareCompany company) {
		this.company = company;
	}
	
	public void readEverything() {
		//read everything from csvs
		try {
			readStudents();
			readTeachers(teacherCSV);
			readClassrooms();
			//company.setTeacherStatus();
			readImmunizationRules();
			readImmunizationRecord();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public List<String> readFile(String csv) throws FileNotFoundException {
		/*
		 * read a csv file and return a list of strings.
		 *  each element is a line
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
		/*
		 * read the students.csv create and load all Student objects into the company
		 * File format:
		 * 		id,fname,lname,age,dateOfEnroll,fatherName,motherName
		 */
		List<String> students = readFile(studentCSV);
		for (String student : students) {
			String[] info = student.split(",");
			this.company.addStudentToList((new Student(info)));
			studentIds+=1;
		}
	}
	
	public void readTeachers(String csv) throws FileNotFoundException, NumberFormatException, ParseException{
		//id,fname,lname,age,dateOfEnrollment,stateLevel
		List<String> teacher = readFile(teacherCSV);
		for (String t : teacher) {
			this.company.addTeacherToList((new Teacher(t)));
		}
	}

	public void readImmunizationRecord() throws FileNotFoundException, NumberFormatException, ParseException {
		/*
		 * read record.csv load all record to each person's immunizationRecord
		 * Format:
		 * 		person_id,immunization_id,immunizationName,age,date
		 */
		List<String> records = readFile(recordCSV);
		SimpleDateFormat ft = new SimpleDateFormat ("MM-dd-yyyy");//MM-dd-yyyy
		for (String record : records) {
			String[] info = record.split(",");
			int person_id = Integer.parseInt(info[0]);
			int immu_id = Integer.parseInt(info[1]);
			for (Person person : this.company.getStudents()) {
				// find the person
				if (person_id == person.getId()) {
					// create an immunization object
					Immunization i = new Immunization(immu_id, 
													info[2], 
													Integer.parseInt(info[3]),
													//new SimpleDateFormat("MM-dd-yyyy").parse(info[4]));
													ft.parse(info[4]));
					// add the immunization object to the person's record
					person.getImmunizationRecord().AddImmunization(i);
				}
			}
		}
	}

	public void readClassrooms() throws FileNotFoundException, NumberFormatException, ParseException {
		/*
		 * read classroom.csv: 
		 * 1) create classroom objects 
		 * 2) load all persons to each classroom
		 * 3) add classrooms to daycare_company
		 * 
			File Format: 
		 * 		classroomID;Rule_ID;student1_ID,student2_ID,student3_ID;teacherID
		 */
		List<String> classrooms = readFile(classroomCSV);
		String[] students = null; // students'id
		String[] teachers = null;
		int numberOfClassRooms=1;
		for (String classroom : classrooms) {
			String[] info = classroom.split(";");
			for(String l:info) {
			System.out.print(l);
			System.out.println();
			
			}
			int classroom_id = Integer.parseInt(info[0]); // classroom id
			int classroom_rule_id = Integer.parseInt(info[1]); // classroomRule id
			if(info.length > 2) {
			 students = info[2].split(","); // students'id
			 teachers = info[3].split(","); // teachers'id
			}

			// create a classroom object
			ClassRoom aClass = new ClassRoom(classroom_id,classroom_rule_id,findClassroomRule(classroom_rule_id));
			
			//add students to the classroom
			if(students != null) {
			for(String student_id:students) {
				aClass.addStudent(findStudent(Integer.parseInt(student_id)));
			}
			}
			
			//add teachers to the classroom
			if(teachers != null) {
			for(String teacher_id:teachers) {
				Teacher t=(Teacher) findTeacher(Integer.parseInt(teacher_id));
				t.setIdle(false);
				aClass.addTeacher(t);
			}
			}
			
			// add the new classroom object to the company
			System.out.println(aClass.Output());
			this.company.addClassRoom(aClass);
			numberOfClassRooms+=1;
			this.company.setClassRoomID(numberOfClassRooms);

		}
	}
	
	public ClassRoomRule findClassroomRule(int rule_id) {
		//find classroom rule object
		for(ClassRoomRule r:this.company.getClassRuleSet()) {
			if(r.getRuleID()==rule_id) {
				return r;
			}
		}
		System.err.println("Unable to locate Classroom_Rule "+rule_id);
		return null;
	}
	
	public Person findStudent(int id) {
		//look for a specific student based on id
		for(Person s:this.company.getStudents()) {
			if(s.getId()==id) {
				return s;
			}
		}
		System.err.println("Unable to locate student "+id);
		return null;
	}
	
	public Person findTeacher(int id) {
		//look for a specific teacher based on id
		for(Person t:this.company.getTeachers()) {
			if(t.getId()==id) {
				return t;
			}
		}
		System.err.println("Unable to locate teacher "+id);
		return null;
	}

	public void readImmunizationRules() throws FileNotFoundException, NumberFormatException, ParseException {
		/*
		 * read ImmunizationRuleCSV
		 * create Rule objects
		 * load Rule objects into DayCare Company
		 * 
		 * Format: "ImmuID, ageLowerLimit, ageUpperLimit, immunization,requiredAmt"
		 */
		List<String> rules = readFile(ImmunizationRuleCSV);
		
		// create Rule object and add it to the company rule list
		for(String rule:rules) {
			ImmunizationRule r = new ImmunizationRule(rule);
			this.company.addImmunizationRule(r);
		}
		
	
		
		
	}
	

}
