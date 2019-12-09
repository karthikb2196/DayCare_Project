package edu.neu.csye6200.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Person {
private int id;
private String firstName;
private String lastName;
private int age;
private ImmunizationRecord immunizationRecord;
//to add to csv
SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/yyyy");//MM-dd-yyyy
private Date dateOfEnrollment;
private int ruleID;


public Person() {
	super();
	// TODO Auto-generated constructor stub
}

public Person(int id, String firstName, String lastName, int age,Date dateOfEnrollment) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.dateOfEnrollment = dateOfEnrollment;
	this.immunizationRecord = new ImmunizationRecord(id);
	setRuleID(age);
}

// To get back 
public Person(String csvData) {
	try {
		
	String[] args = csvData.split(",");
	 int id = Integer.parseInt(args[0]);
	 String firstName = args[1];
	 String lastName = args[2];
	 int age = Integer.parseInt(args[3]);
	 Date dateOfEnrollment = null;
	 dateOfEnrollment = ft.parse(args[4]);
	 
	 
	 this.setId(id);
	 this.setFirstName(firstName);
	 this.setLastName(lastName);
	 this.setAge(age);
	 this.setDateOfEnrollment(dateOfEnrollment);
	 this.setImmunizationRecord(new ImmunizationRecord(id));
	 setRuleID(age);
	 
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

//// To create student objects using string
//public void createPersonUsingString(String stringData) {
//	String[] args = stringData.split(",");
//	try {
//	 int id = Integer.parseInt(args[0]);
//	 String firstName = args[1];
//	 String lastName = args[2];
//	 int age = Integer.parseInt(args[3]);
//	 Instant instantDateOfEnrollment = Instant.parse(args[4]);
//	 Date dateOfEnrollment = Date.from(instantDateOfEnrollment);
//	 
//	 this.setId(id);
//	 this.setFirstName(firstName);
//	 this.setLastName(lastName);
//	 this.setAge(age);
//	 this.setDateOfEnrollment(dateOfEnrollment);
//	}
//	catch(Exception e) {
//		e.printStackTrace();
//	}
//}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public ImmunizationRecord getImmunizationRecord() {
	return immunizationRecord;
}
public void setImmunizationRecord(ImmunizationRecord immunizationRecord) {
	this.immunizationRecord = immunizationRecord;
}

public Date getDateOfEnrollment() {
	return dateOfEnrollment;
}

public void setDateOfEnrollment(Date dateOfEnrollment) {
	this.dateOfEnrollment = dateOfEnrollment;
}

public int getRuleID() {
	return ruleID;
}

public void setRuleID(int age) {
	if(age <= 12 && age>=6) {
		this.ruleID = 1;
	}
	else if(age <= 24 && age>=13) {
		this.ruleID = 2;
	}
	else if(age <= 35 && age>=25) {
		this.ruleID = 3;
	}
	else if(age<= 47 && age>=36) {
		this.ruleID = 4;
	}
	else if(age<= 59 && age>=48) {
		this.ruleID = 5;
	}
	else {
		this.ruleID = 6;
	}
}

@Override
public String toString() {
	return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
			+ ", immunizationRecord=" + immunizationRecord + ", dateOfEnrollment=" + ft.format(dateOfEnrollment) + "]";
}

public static void demo() {
	Person person1 = new Person(1,"bsvg","vcgveg",1,new Date());
	System.out.println(person1.toString());
	Person person2 = new Person("25,jim,hello,1,10-22-2019");//"25,jim,hello,1,2018-10-28T15:23:01Z"
	System.out.println(person2.toString());
	
	
}
}
