package com.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.bean.Course;
import com.bean.Learner;
import com.exception.CourseNotFoundException;
import com.exception.LearnerAlreadyExistException;
import com.exception.LearnerNotFoundxception;
import com.exception.MaxSessionAttendedException;

public interface ElearningManagementInterface {
	
	public boolean addLearner(int courseId,Learner l)throws CourseNotFoundException,LearnerAlreadyExistException;
	public HashMap<Course,Integer> getLearnersCount();
	public ArrayList<Course> getNonTechnicalCourses(int count);
	public boolean updateAttendence(int courseId,int enrollmentId)throws MaxSessionAttendedException,CourseNotFoundException,LearnerNotFoundxception;
	

}
