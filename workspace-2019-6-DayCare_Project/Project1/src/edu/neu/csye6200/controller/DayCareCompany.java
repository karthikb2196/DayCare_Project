package edu.neu.csye6200.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import edu.neu.csye6200.model.ClassRoom;
import edu.neu.csye6200.model.ClassRoomRule;
import edu.neu.csye6200.model.DTapImmunization;
import edu.neu.csye6200.model.HepBImmunization;
import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.model.ImmunizationRecord;
import edu.neu.csye6200.model.ImmunizationRule;
import edu.neu.csye6200.model.MMRImmunization;
import edu.neu.csye6200.model.Person;
import edu.neu.csye6200.model.Rule;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.VaricellaImmunization;


public class DayCareCompany {

	private List<Person> teachers = new ArrayList<>();
	private List<Person> students = new ArrayList<>();
	private List<ImmunizationRecord> immunizationDirectory = new ArrayList<ImmunizationRecord>();
	private List<ClassRoomRule> classRuleSet = new ArrayList<ClassRoomRule>();
	private List<ClassRoom> classRooms = new ArrayList<ClassRoom>();
	private List<ClassRoom> tempClassRooms = new ArrayList<ClassRoom>();
	private List<Immunization> immunizations = new ArrayList<>();//a list of all immunizations we have right now
	private int numberOfClassrooms;
	private List<ImmunizationRule> immunizationRules = new ArrayList<>();
	private int classRoomID = 1; //next classrooms if students exceed
	private final String studentCSV = "students.csv";
	private final static String teacherCSV = "teachers.csv";
	private DataWriter writer;
	
	
	
	public DataWriter getWriter() {
		return writer;
	}
	public void setW(DataWriter w) {
		this.writer = w;
	}
	public List<ImmunizationRule> getImmunizationRules() {
		return immunizationRules;
	}
	public void setImmunizationRules(List<ImmunizationRule> immunizationRules) {
		this.immunizationRules = immunizationRules;
	}
	public List<Immunization> getImmunizations() {
		return immunizations;
	}
	public void setImmunizations(List<Immunization> immunizations) {
		this.immunizations = immunizations;
	}
	public List<Person> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Person> teachers) {
		this.teachers = teachers;
	}
	public List<Person> getStudents() {
		return students;
	}
	public void setStudents(List<Person> students) {
		this.students = students;
	}
	public List<ImmunizationRecord> getImmunizationDirectory() {
		return immunizationDirectory;
	}
	public void setImmunizationDirectory(List<ImmunizationRecord> immunizationDirectory) {
		this.immunizationDirectory = immunizationDirectory;
	}
	public List<ClassRoom> getClassRooms() {
		return classRooms;
	}
	public void setClassRooms(List<ClassRoom> classRooms) {
		this.classRooms = classRooms;
	}
	
	public int getClassRoomID() {
		return classRoomID;
	}
	public void setClassRoomID(int classRoomID) {
		this.classRoomID = classRoomID;
	}
	public List<ClassRoom> getClassRoomList(Person s){
		List<ClassRoom> classRooms = new ArrayList<ClassRoom>();
		for(ClassRoom c : this.getClassRooms()) {
			if(s.getRuleID()==c.getRuleID() && c.getNumberOfStudents() != c.getMaxStudents()) {
				classRooms.add(c);
			}
		}
		//Adding new classroom
		if(classRooms.size() == 0) {
			int ruleID = s.getRuleID();
			ClassRoomRule tempRule=null;
			for(ClassRoomRule rule : classRuleSet) {
				if(ruleID == rule.getRuleID()) {
					tempRule = rule;
				}
			}
			ClassRoom newClass = new ClassRoom(classRoomID,ruleID,tempRule);
			classRoomID+=1;
			this.addClassRoom(newClass);
			classRooms.add(newClass);
		}
		return classRooms;
	
	}
	// to add student to the list of student
		public void addStudentToList(Person s) {
			this.students.add(s);
		}
		// to add teacher to the list of student
		public void addTeacherToList(Person s) {
			this.teachers.add(s);
		}
	public void addStudent(Person s) {
		/*
		 * add a new student to the classroom 
		 * create classroom based on classroom rule
		 */
		this.getStudents().add(s);
		tempClassRooms = getClassRoomList(s);
		for(ClassRoom classRoom : tempClassRooms) {
			int addStudent= classRoom.addStudent(s);
			if(addStudent <= classRoom.getMaxStudents() && addStudent >=  0) {
				this.addStudentToCSV();
				this.addClassRoomToCSV();
				System.out.println("Student added to classroom: "+classRoom.getClassRoomID());
			}
			else {
				System.out.println("Student not added");
			}
			
			if(addStudent==1) {
				Teacher teacher = getTeacher(classRoom.getRuleID());
				if(teacher!=null) {
				System.out.println("Teacher"+teacher.getId()+" added to class"+classRoom.getClassRoomID());
				classRoom.addTeacher(teacher);
				this.addClassRoomToCSV();
				}
				else {
					System.out.println("No teacher available");
				}
			}
			
			for(int i=1;i<=classRoom.getNumberOfGroups()-1;i++) {
				if(addStudent==classRoom.getGroupSize()*i+1) {
					Teacher teacher = getTeacher(classRoom.getRuleID());
					if(teacher!=null) {
					System.out.println("Teacher"+teacher.getId()+" added to class"+classRoom.getClassRoomID());
					classRoom.addTeacher(teacher);
					}
					else {
						System.out.println("No teacher available");
					}
				}
				else {
					
				}
			}
		}
	}
	
	public void setTeacherStatus() {
		//set idle status of all teachers who are teaching as False
		//must call this function after readTeachers
		for(ClassRoom c:this.getClassRooms()) {
			for(Person t:c.getTeachers()) {
				((Teacher) t).setIdle(false);
			}
		}
	}
	
	public boolean CheckTeacherEligibility(Teacher teacher,int classRoomRuleID) {
		if(teacher.isIdle()== true) {
				return true;
		}
		return false;
	}
	
	public Teacher getTeacher(int classRoomRuleID) {
		Teacher teacher = null;
		for(Person t: this.getTeachers()) {
			if(((Teacher) t).getStateLevel()==classRoomRuleID) {
				boolean check = CheckTeacherEligibility((Teacher) t,classRoomRuleID);
				if(check==true) {
					teacher = (Teacher) t;
					break;
				}
			}	
		}
		return teacher;
	}
	
	public void addTeacher(Person s) {
		this.teachers.add(s);
	}
	
	public void addImmunization(Immunization i) {
		this.immunizations.add(i);
	}
	
	public void addClassRoom(ClassRoom c) {
		
		this.getClassRooms().add(c);
	}
	
	public List<ClassRoomRule> getClassRuleSet() {
		return classRuleSet;
	}
	public void setClassRuleSet(ClassRoomRule classRule) {
		classRuleSet.add(classRule);
	}
	
	
	@Override
	public String toString() {
		return "DayCareCompany [teachers=" + teachers + ", students=" + students + ", immunizationDirectory="
				+ immunizationDirectory + ", classRuleSet=" + classRuleSet + ", classRooms=" + classRooms
				+ ", tempClassRooms=" + tempClassRooms + ", immunizations=" + immunizations + ", numberOfClassrooms="
				+ numberOfClassrooms + ", immunizationRules=" + immunizationRules + ", classRoomID=" + classRoomID
				+ ", studentCSV=" + studentCSV + ", writer=" + writer + "]";
	}
	public int checkRequiredDose(int age, Immunization immu) {
		// decide how many dose of an immunization should be taken based on age
		for (ImmunizationRule rule : this.immunizationRules) {
			if (rule.getAgeLowerLimit() < age && age < rule.getAgeUpperLimit()
					&& rule.getRuleID() == immu.getImmunizationID()) {
				return rule.getRequiredAmt();
			}
		}
		System.err.println("Invalid Age Input. Unable to decide required dose. ");
		return -1;
	}
	
	public int doseTaken(Person p,int immu_id) {
		//count how many doses have been taken
		return p.getImmunizationRecord().doseTaken(immu_id);	
	}

	public int expectedDose(Person p, Immunization immu) {
		// how many vaccine should be taken in the future
		return (checkRequiredDose(p.getAge(), immu) - doseTaken(p,immu.getImmunizationID()));
	}

	public void CheckImmunizationRecord(Person p) {
		/*
		 * Check a person's immu record and decide what requirements are not meet yet
		 */
		StringBuilder sb = new StringBuilder();
		for (Immunization im : p.getImmunizationRecord().getImmunizationList()) {
			int needDoseAmt = expectedDose(p, im);
			if(needDoseAmt > 0) {
				sb.append("Student "+p.getId()+" still needs to take "+(needDoseAmt)+" "+im.getImmunizationName()+"\n");
			}
		}
		System.out.println(sb);
	}
	

	public void CheckImmunizationRecord(int id) {
		/*
		 * Check a person's immu record and decide what requirements are not meet yet
		 */
		StringBuilder sb = new StringBuilder();
		Person p = findStudentByID(id);
		for(ImmunizationRule r:this.getImmunizationRules()) {
			if(r.getAgeLowerLimit()<=p.getAge() && r.getAgeUpperLimit()>p.getAge()) {
				int taken = p.getImmunizationRecord().doseTaken(r.getRuleID());
				int stillNeed = r.getRequiredAmt()-taken;
				if(stillNeed>0) {
					sb.append("Student "+p.getId()+" still needs to take "+(stillNeed)+" "+r.getImmunization()+"\n");
				}
			}
		}
		System.out.println(sb);
	}

	public Person findStudentByID(int id) {
		//find student by id
		for(Person s:this.getStudents()) {
			if(s.getId()==id) {
				return s;
			}
		}
		System.out.println("Unable to find student (ID= "+id+")");
		return null;
	}
	
	public void addImmunizationToStudent(int student_id,Immunization i) {
		//add an immunization to a student 
		findStudentByID(student_id).getImmunizationRecord().AddImmunization(i);
	}
	
	public void addImmunizationRule(ImmunizationRule r) {
		//add an immunizationRule
		this.getImmunizationRules().add(r);
		System.out.println("Add new immunization rule: \n"+r.toString());
	}
	
	public void addStudentToCSV() {
		System.out.println("Write student data into students.csv");
		try {
			this.getWriter().writeStudentData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addTeacherToCSV() {
		System.out.println("Write student data into students.csv");
		try {
			this.getWriter().writeTeacherData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addClassRoomToCSV() {
		System.out.println("Write student data into students.csv");
		try {
			this.getWriter().writeClassRoomData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void demo() {
//		
//		ClassRoomRule rule1 = new ClassRoomRule(1,"Classroom for ages 6-12", 12, 6, 0.25,4, 12,3);
//		ClassRoomRule rule2 = new ClassRoomRule(2,"Classroom for ages 13-24", 24, 13, 0.20,5, 15,3);
//		ClassRoomRule rule3 = new ClassRoomRule(3,"Classroom for ages 25-35", 35, 25, 0.20,6, 18,3);
//		ClassRoomRule rule4 = new ClassRoomRule(4,"Classroom for ages 36-47", 47, 36, 0.20,8, 24,3);
//		ClassRoomRule rule5 = new ClassRoomRule(5,"Classroom for ages 48-59", 59, 48, 0.20,12, 24,2);
//		ClassRoomRule rule6 = new ClassRoomRule(6,"Classroom for ages 60 and above", 24,60, 0.20,15,30,2);
//		dayCareCompany.setClassRuleSet(rule1);
//		dayCareCompany.setClassRuleSet(rule2);
//		dayCareCompany.setClassRuleSet(rule3);
//		dayCareCompany.setClassRuleSet(rule4);
//		dayCareCompany.setClassRuleSet(rule5);
//		dayCareCompany.setClassRuleSet(rule6);
//		
//		ClassRoom classRoom1 = new ClassRoom(1,1,rule1);
//		ClassRoom classRoom2 = new ClassRoom(2,2,rule2);
//		ClassRoom classRoom3 = new ClassRoom(3,3,rule3);
//		ClassRoom classRoom4 = new ClassRoom(4,4,rule4);
//		ClassRoom classRoom5 = new ClassRoom(5,5,rule5);
//		ClassRoom classRoom6 = new ClassRoom(6,5,rule6);
////	
////		
//		dayCareCompany.addClassRoom(classRoom1);
//		dayCareCompany.addClassRoom(classRoom2);
//		dayCareCompany.addClassRoom(classRoom3);
//		dayCareCompany.addClassRoom(classRoom4);
//		dayCareCompany.addClassRoom(classRoom5);
//		dayCareCompany.addClassRoom(classRoom6);
//		
//		Student student1 = new Student(1,"john","kinkade",15,new Date(),"GG","JJ");
//		Student student2 = new Student(2,"dan","manheim",15,new Date(),"GG","JJ");
//		Student student3 = new Student(3,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student4 = new Student(4,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student5 = new Student(5,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student6 = new Student(6,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student7 = new Student(7,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student8 = new Student(8,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student9 = new Student(9,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student10 = new Student(10,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student11 = new Student(11,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student12 = new Student(12,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student13 = new Student(13,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student14 = new Student(14,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student15 = new Student(15,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student16 = new Student(16,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student17 = new Student(17,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student18 = new Student(18,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student19 = new Student(19,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student20 = new Student(20,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student21 = new Student(21,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student22 = new Student(22,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student23 = new Student(23,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student24 = new Student(24,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//		Student student25 = new Student(25,"bsvg","vcgveg",7,new Date(),"GG","JJ");
//////		Student student15 = new Student("25,jim,hello,26,10-22-2019,john,JJ");
//		
//		Teacher teacher1 = new Teacher(12, "Jogn", "jssn", 25, new Date(), 1);
//		Teacher teacher2 = new Teacher(13, "J1", "j1", 25, new Date(), 1);
//		Teacher teacher3 = new Teacher(14, "J2", "j2", 25, new Date(), 1);
//		Teacher teacher4 = new Teacher(15, "J3", "j3", 25, new Date(), 1);
//		Teacher teacher5 = new Teacher(16, "J4", "j4", 25, new Date(), 1);
//		Teacher teacher6 = new Teacher(17, "J5", "j5", 25, new Date(), 1);
//		Teacher teacher7 = new Teacher(18, "J6", "j6", 25, new Date(), 1);
//		Teacher teacher8 = new Teacher(19, "J7", "j7", 25, new Date(), 1);
//		Teacher teacher9 = new Teacher(20, "J8", "j8", 25, new Date(), 2);
////		dayCareCompany.addTeacher(teacher1);
////		dayCareCompany.addTeacher(teacher2);
////		dayCareCompany.addTeacher(teacher3);
////		dayCareCompany.addTeacher(teacher4);
////		dayCareCompany.addTeacher(teacher5);
////		dayCareCompany.addTeacher(teacher6);
////		dayCareCompany.addTeacher(teacher7);
////		dayCareCompany.addTeacher(teacher8);
////		dayCareCompany.addTeacher(teacher9);
////		
////		dayCareCompany.addStudent(student1);
////		dayCareCompany.addStudent(student2);
////		dayCareCompany.addStudent(student3);
////		dayCareCompany.addStudent(student4);
////		dayCareCompany.addStudent(student5);
////		dayCareCompany.addStudent(student6);
////		dayCareCompany.addStudent(student7);
////		dayCareCompany.addStudent(student8);
////		dayCareCompany.addStudent(student9);
////		dayCareCompany.addStudent(student10);
////		dayCareCompany.addStudent(student11);
////		dayCareCompany.addStudent(student12);
////		dayCareCompany.addStudent(student13);
////		dayCareCompany.addStudent(student14);
////		dayCareCompany.addStudent(student15);
////		dayCareCompany.addStudent(student16);
////		dayCareCompany.addStudent(student17);
////		dayCareCompany.addStudent(student18);
////		dayCareCompany.addStudent(student19);
////		dayCareCompany.addStudent(student20);
////		dayCareCompany.addStudent(student21);
////		dayCareCompany.addStudent(student22);
////		dayCareCompany.addStudent(student23);
////		dayCareCompany.addStudent(student24);
////		dayCareCompany.addStudent(student25);
////		System.out.println(dayCareCompany);
//		

//		Immunization dtap = new DTapImmunization(1, "DTap", 10, new Date());
//		Immunization hepB = new HepBImmunization(2, "HepB", 10, new Date());
//		Immunization mmr = new MMRImmunization(3, "MMR", 10, new Date());
//		student1.getImmunizationRecord().AddImmunization(dtap);
//		student1.getImmunizationRecord().AddImmunization(hepB);
//		student1.getImmunizationRecord().AddImmunization(mmr);
//		System.out.println(student1.output());
		
		DayCareCompany dayCareCompany = new DayCareCompany();
		dayCareCompany.setW(new DataWriter(dayCareCompany));
		DataLoader loader = new DataLoader(dayCareCompany);
		
		ClassRoomRule rule1 = new ClassRoomRule(1,"Classroom for ages 6-12", 12, 6, 0.25,4, 12,3);
		ClassRoomRule rule2 = new ClassRoomRule(2,"Classroom for ages 13-24", 24, 13, 0.20,5, 15,3);
		ClassRoomRule rule3 = new ClassRoomRule(3,"Classroom for ages 25-35", 35, 25, 0.20,6, 18,3);
		ClassRoomRule rule4 = new ClassRoomRule(4,"Classroom for ages 36-47", 47, 36, 0.20,8, 24,3);
		ClassRoomRule rule5 = new ClassRoomRule(5,"Classroom for ages 48-59", 59, 48, 0.20,12, 24,2);
		ClassRoomRule rule6 = new ClassRoomRule(6,"Classroom for ages 60 and above", 24,60, 0.20,15,30,2);
		dayCareCompany.setClassRuleSet(rule1);
		dayCareCompany.setClassRuleSet(rule2);
		dayCareCompany.setClassRuleSet(rule3);
		dayCareCompany.setClassRuleSet(rule4);
		dayCareCompany.setClassRuleSet(rule5);
		dayCareCompany.setClassRuleSet(rule6);


		
		loader.readEverything();
		System.out.println(dayCareCompany);
		dayCareCompany.CheckImmunizationRecord(1);
		dayCareCompany.getWriter().writeEverything();

		
	}
	
}
