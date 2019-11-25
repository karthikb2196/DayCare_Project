package edu.neu.csye6200.model;

import java.util.Date;

public class Teacher extends Person implements Comparable<Teacher> {

//	private int teacherId;// automatically increased by 1, start at 1001
	private boolean isIdle = true;// mark whether the teacher is ready for classes or not, true means can be
									// arranged. If all teachers are not idle
	private int stateLevel;// the level this teacher is available to teach. 1 means 6-12month, etc.
//	private Date registerTime;

	public Teacher(int id, String firstName, String lastName, int age, Date dateOfEnrollment,
			int StateLevel) {
		super(id, firstName, lastName, age, dateOfEnrollment);
		stateLevel = StateLevel;
		// TODO Auto-generated constructor stub
	}

	public Teacher(String csvData) {
		super();
		try {
			String[] args = csvData.split(",");
			int Id = Integer.parseInt(args[0]);
			String firstName = args[1];
			String lastName = args[2];
			int age = Integer.parseInt(args[3]);
			Date dateOfEnrollment = null;
			dateOfEnrollment = ft.parse(args[4]);
			int stateLevel = Integer.parseInt(args[5]);

			this.setId(Id);
			this.setFirstName(firstName);
			this.setLastName(lastName);
			this.setAge(age);
			this.setDateOfEnrollment(dateOfEnrollment);
			this.setImmunizationRecord(new ImmunizationRecord(Id));
			this.setStateLevel(stateLevel);

		} catch (Exception e) {
			e.printStackTrace();
		}
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
		return this.getId() + " " + this.getFirstName() + " " + this.getLastName() + " "
				+ this.getStateLevel() + this.getAge() + " " + this.getClass() + " " + this.getImmunizationRecord();

	}

	@Override
	public String toString() {
		return  getId() + "," + isIdle + "," + stateLevel + "," + getFirstName() + "," + getLastName() ;
//		+ ","+ getAge() + "," + getImmunizationRecord() + ","+ getDateOfEnrollment() ;
	}

	@Override
	public int compareTo(Teacher tch) {
		// TODO Auto-generated method stub
		return Integer.valueOf(this.getId()).compareTo(tch.getId());
	}

	public static void demo() {
		Teacher teacher1 = new Teacher(12, "Jogn", "jssn", 25, new Date(), 1);
		System.out.println(teacher1);
		Teacher teacher2 = new Teacher("13,Jasdasgn,jsasdn,25,12-10-2019,1");
		System.out.println(teacher2);
//		13, "Jasdasgn", "jsasdn", 25,12-10-2019, 1
	}
}
