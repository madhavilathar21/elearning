package com.bean;

import java.util.ArrayList;

public class Course {
	
	private int courseId;
	private String courseName;
	private int sessionCount;
	
	ArrayList<Learner> learnerList=new ArrayList<Learner>();
	
	public ArrayList<Learner> getLearnerList() {
		return learnerList;
	}
	public void setLearnerList(ArrayList<Learner> learnerList) {
		this.learnerList = learnerList;
	}
	public Course(int courseId, String courseName, int sessionCount) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.sessionCount = sessionCount;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getSessionCount() {
		return sessionCount;
	}
	public void setSessionCount(int sessionCount) {
		this.sessionCount = sessionCount;
	}

}
