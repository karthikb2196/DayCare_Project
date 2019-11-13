package edu.neu.csye6200.model;

public class ClassRoomRule implements Rule {
	
	private int ruleID;
	private String ruleDescription;
	private int ageUpperLimit;
	private int ageLowerLimit;
	private float ratio; //student:teacher
	private int groupSize; 
	private int maxStudents;
	private int maxTeachers;

	public ClassRoomRule(int ruleID, String ruleDescription, int ageUpperLimit, int ageLowerLimit, float ratio,
			int groupSize, int maxStudents, int maxTeachers) {
		this.ruleID = ruleID;
		this.ruleDescription = ruleDescription;
		this.ageUpperLimit = ageUpperLimit;
		this.ageLowerLimit = ageLowerLimit;
		this.ratio = ratio;
		this.groupSize = groupSize;
		this.maxStudents = maxStudents;
		this.maxTeachers = maxTeachers;
	}
	
	public ClassRoomRule(String csv) {
		/*
		 * read a csv file and store the rule to obj
		 */
		this.ruleID = ruleID;
		this.ruleDescription = ruleDescription;
		this.ageUpperLimit = ageUpperLimit;
		this.ageLowerLimit = ageLowerLimit;
		this.ratio = ratio;
		this.groupSize = groupSize;
		this.maxStudents = maxStudents;
		this.maxTeachers = maxTeachers;
	}

	public int getRuleID() {
		return ruleID;
	}

	public void setRuleID(int ruleID) {
		this.ruleID = ruleID;
	}

	public int getAgeUpperLimit() {
		return ageUpperLimit;
	}

	public void setAgeUpperLimit(int ageUpperLimit) {
		this.ageUpperLimit = ageUpperLimit;
	}

	public int getAgeLowerLimit() {
		return ageLowerLimit;
	}

	public void setAgeLowerLimit(int ageLowerLimit) {
		this.ageLowerLimit = ageLowerLimit;
	}

	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}

	public int getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public int getMaxTeachers() {
		return maxTeachers;
	}

	public void setMaxTeachers(int maxTeachers) {
		this.maxTeachers = maxTeachers;
	}

	@Override
	public String getRuleDescription() {
		// TODO Auto-generated method stub
		return this.ruleDescription;
	}

	@Override
	public void setRuleDescription(String descr) {
		// TODO Auto-generated method stub
		this.ruleDescription=descr;
	}

}
