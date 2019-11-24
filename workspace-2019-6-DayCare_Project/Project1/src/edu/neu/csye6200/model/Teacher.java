package edu.neu.csye6200.model;

import java.util.Date;

public class Teacher extends Person implements Comparable<Teacher> {

	private int teacherId;// automatically increased by 1, start at 1001
	private boolean isIdle = true;// mark whether the teacher is ready for classes or not, true means can be
									// arranged. If all teachers are not idle
	private int stateLevel;// the level this teacher is available to teach. 1 means 6-12month, etc.
//	private Date registerTime;

	public Teacher(int id, int TeacherId, String firstName, String lastName, int age, Date dateOfEnrollment,
			int StateLevel) {
		super(id, firstName, lastName, age, dateOfEnrollment);
		teacherId = TeacherId;
		stateLevel = StateLevel;

		// TODO Auto-generated constructor stub
	}

	public Teacher(String csvData) {
		super();
		try {
			String[] args = csvData.split(",");
			int teacherId = Integer.parseInt(args[0]);
			String firstName = args[1];
			String lastName = args[2];
			int age = Integer.parseInt(args[3]);
			Date dateOfEnrollment = null;
			dateOfEnrollment = ft.parse(args[4]);
			int stateLevel = Integer.parseInt(args[5]);

			this.setId(teacherId);
			this.setFirstName(firstName);
			this.setLastName(lastName);
			this.setAge(age);
			this.setDateOfEnrollment(dateOfEnrollment);
			this.setImmunizationRecord(new ImmunizationRecord(teacherId));
			this.setStateLevel(stateLevel);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", isIdle=" + isIdle + ", stateLevel=" + stateLevel + ", getId()="
				+ getId() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getAge()="
				+ getAge() + ", getImmunizationRecord()=" + getImmunizationRecord() + ", getDateOfEnrollment()="
				+ getDateOfEnrollment() + "]";
	}

	@Override
	public int compareTo(Teacher tch) {
		// TODO Auto-generated method stub
		return Integer.valueOf(teacherId).compareTo(tch.teacherId);
	}

	public static void demo() {
		Teacher teacher1 = new Teacher(12, 2, "Jogn", "jssn", 25, new Date(), 1);
		System.out.println(teacher1.output());
		Teacher teacher2 = new Teacher(13, 1, "Jasdasgn", "jsasdn", 25, new Date(), 1);
		System.out.println(teacher2.output());
	}
}
