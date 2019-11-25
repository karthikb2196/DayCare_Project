package edu.neu.csye6200.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import edu.neu.csye6200.model.ClassRoom;
import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.model.ImmunizationRecord;
import edu.neu.csye6200.model.ImmunizationRule;
import edu.neu.csye6200.model.Person;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;

public class DataWriter {

	private DayCareCompany company;
	private final String studentCSV = "students.csv";
	private final String teacherCSV = "teachers.csv";
	private final String recordCSV = "records.csv";
	private final String classroomCSV = "classrooms.csv";
	private final String ImmunizationRuleCSV = "ImmunizationRules.csv";

	public DataWriter(DayCareCompany company) {
		this.company = company;
	}

	public void writeStudentData() throws IOException {
		/*
		 * write all students' info to teacher.csv 
		 * File format:
		 * 			Student_id,firstName,lastName,age,dateOfEnrollment,FatherName,MotherName
		 */
		FileWriter fileWriter = new FileWriter(studentCSV);
		BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
		String info = "";
		for (Person s : this.company.getStudents()) {
			info = s.getId() + "," + s.getFirstName() + "," + s.getLastName() + "," + s.getAge() + ","
					+ s.getDateOfEnrollment() + "," + ((Student) s).getFatherName() + ","
					+ ((Student) s).getMotherName();
			// write info line to csv
			bufferWriter.write(info);
			bufferWriter.newLine();
		}
		bufferWriter.flush();
		bufferWriter.close();
	}

	public void writeTeacherData() throws IOException {
		/*
		 * write all teachers' info to teachers.csv 
		 * File format:
		 * 			id,fname,lname,age,dateOfEnrollment,stateLevel
		 */
		FileWriter fileWriter = new FileWriter(teacherCSV);
		BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
		String info = "";
		for (Person t : this.company.getTeachers()) {
			info = t.getId() + "," + t.getFirstName() + "," + t.getLastName() + "," + t.getAge() + ","
					+ t.getDateOfEnrollment() + "," + ((Teacher) t).getStateLevel();
			// write info line to csv
			bufferWriter.write(info);
			bufferWriter.newLine();
		}
		bufferWriter.flush();
		bufferWriter.close();

	}

	public void writeImmunizationRecordData() throws IOException {
		/*
		 * write all persons' immunization record to records.csv 
		 * File format:
		 * 		PersonID,immunizationID ,immunizationName, ageReceived,dateReceived,numberOfDosesGiven
		 */
		FileWriter fileWriter = new FileWriter(recordCSV);
		BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
		String info = "";
		for (Person s : this.company.getStudents()) {
			info = s.getId() + ",";
			for (Immunization i : s.getImmunizationRecord().getImmunizationList()) {
				info = info + i.getImmunizationID() + "," 
							+ i.getImmunizationName() + "," 
							+ i.getAgeReceived() + ","
							+ i.getDateReceived() + "," 
							+ i.getNumberOfDosesGiven();
				// write the info line to records.csv
				bufferWriter.write(info);
				bufferWriter.newLine();
			}
		}
		bufferWriter.flush();
		bufferWriter.close();

	}

	public void writeImmunizationRuleData() throws IOException {
		/*
		 * write all persons' immunization rules to ImmunizationRuleCSV 
		 * File Format:
		 * 		ruleID,ageLowerLimit,ageUpperLimit,ruleDescription ,requiredAmt
		 */
		FileWriter fileWriter = new FileWriter(ImmunizationRuleCSV);
		BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
		String info = "";
		for (ImmunizationRule r : this.company.getImmunizationRules()) {
			info = r.getRuleID() + "," 
					+ r.getAgeLowerLimit() + "," 
					+ r.getAgeUpperLimit() + ","
					+ r.getRuleDescription() + "," 
					+ r.getRequiredAmt();
			// write the info line to ImmunizationRuleCSV
			bufferWriter.write(info);
			bufferWriter.newLine();
		}
		bufferWriter.flush();
		bufferWriter.close();

	}

	public void writeClassRoomData() throws IOException {
		/*
		 * write classroom info into classrooms.csv 
		 * File Format: 
		 * 		classroomID; Rule_ID;student1_ID, student2_ID,student3_ID;teacherID
		 */
		FileWriter fileWriter = new FileWriter(classroomCSV);
		BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
		String info = "";
		for (ClassRoom c : this.company.getClassRooms()) {

			// add classroomID and classRoomRuleID
			info = c.getClassRoomID() + ";" + c.getRuleID() + ";";

			// add students' id
			for (Person p : c.getStudents()) {
				info = info + p.getId() + ",";
			}
			if (c.getStudents().size() > 0) {// if the classroom is non-empty
				// replace the last string ","
				info = info.substring(0, info.length() - 1);
			}

			// add teacherID
			info = info + ";" + c.getTeachers().get(0);

			// add classroom info to the csv
			bufferWriter.write(info);
			bufferWriter.newLine();
		}
		bufferWriter.flush();
		bufferWriter.close();
	}

}
