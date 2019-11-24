package edu.neu.csye6200.model;

public class ClassRoomRule implements Rule {
	
	private int ruleID;
	private String ruleDescription;
	private int ageUpperLimit;
	private int ageLowerLimit;
	private double ratio; //student:teacher
	private int groupSize; 
	private int maxStudents;
	private int maxTeachers;

	public ClassRoomRule(int ruleID, String ruleDescription, int ageUpperLimit, int ageLowerLimit, double d,
			int groupSize, int maxStudents, int maxTeachers) {
		this.ruleID = ruleID;
		this.ruleDescription = ruleDescription;
		this.ageUpperLimit = ageUpperLimit;
		this.ageLowerLimit = ageLowerLimit;
		this.ratio = d;
		this.groupSize = groupSize;
		this.maxStudents = maxStudents;
		this.maxTeachers = maxTeachers;
	}
	
	public ClassRoomRule(String csv) {
		String[] args = csv.split(",");
		
		try {
			int ruleID = Integer.parseInt(args[0]);
			String ruleDescription = args[1];
			int ageUpperLimit = Integer.parseInt(args[2]);
			int ageLowerLimit = Integer.parseInt(args[3]);
			double ratio = Double.parseDouble(args[4]);
			int groupSize =Integer.parseInt(args[5]);
			int maxStudents = Integer.parseInt(args[6]);
			int maxTeachers = Integer.parseInt(args[7]);
			
			this.ruleID = ruleID;
			this.ruleDescription = ruleDescription;
			this.ageUpperLimit = ageUpperLimit;
			this.ageLowerLimit = ageLowerLimit;
			this.ratio = ratio;
			this.groupSize = groupSize;
			this.maxStudents = maxStudents;
			this.maxTeachers = maxTeachers;
			
		}
		catch(Exception e) {
			
		}
		/*
		 * read a csv file and store the rule to obj
		 */
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

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
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
