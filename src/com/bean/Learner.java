package com.bean;

public class Learner {
	
	private int enrollmentId;
	private String name;
	private int age;
	private int attendedSessionCount;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAttendedSessionCount() {
		return attendedSessionCount;
	}
	public void setAttendedSessionCount(int attendedSessionCount) {
		this.attendedSessionCount = attendedSessionCount;
	}
	public Learner(int enrollmentId, String name, int age, int attendedSessionCount) {
		super();
		this.enrollmentId = enrollmentId;
		this.name = name;
		this.age = age;
		this.attendedSessionCount = attendedSessionCount;
	}
	public int getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
