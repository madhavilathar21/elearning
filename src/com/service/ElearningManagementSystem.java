package com.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.bean.Course;
import com.bean.Learner;
import com.bean.NonTechnical;
import com.exception.CourseNotFoundException;
import com.exception.LearnerAlreadyExistException;
import com.exception.LearnerNotFoundxception;
import com.exception.MaxSessionAttendedException;

public class ElearningManagementSystem implements ElearningManagementInterface{
	
	ArrayList<Course> cList=new ArrayList<Course>();

	public ArrayList<Course> getcList() {
		return cList;
	}

	public void setcList(ArrayList<Course> cList) {
		this.cList = cList;
	}

	@Override
	public boolean addLearner(int courseId, Learner l) throws CourseNotFoundException, LearnerAlreadyExistException {
		boolean isFound=false;
		for(Course c:cList)
		{
			if(c.getCourseId()==courseId)
			{
				isFound=true;
				for(Learner ll:c.getLearnerList())
				{
					if(ll.getEnrollmentId()==l.getEnrollmentId())
					{
						throw new LearnerAlreadyExistException("Learner already TAgged");
					}
				}
				c.getLearnerList().add(l);
				return true;
			}
		}
		if(isFound==false)
		{
			throw new CourseNotFoundException("Course not found excpetion");
		}
		return false;
	}

	@Override
	public HashMap<Course, Integer> getLearnersCount() {
		
		HashMap<Course, Integer> map=new HashMap<Course, Integer>();
		for(Course c:cList)
		{
			int count=0;
			for(Learner ll:c.getLearnerList())
			{
				if(ll.getAttendedSessionCount()==c.getSessionCount())
				{
					count++;
				}
			}
			map.put(c, count);
		}
		
		
		return map;
	}

	@Override
	public ArrayList<Course> getNonTechnicalCourses(int count) {
		ArrayList<Course> cclist=new ArrayList<Course>();
		for(Course c:cList)
		{
			if(c instanceof NonTechnical)
			{
				if(c.getSessionCount()>count)
				{
					cclist.add(c);
                }


			}
		}
		return cclist;
	}

	@Override
	public boolean updateAttendence(int courseId, int enrollmentId)
			throws MaxSessionAttendedException, CourseNotFoundException, LearnerNotFoundxception {
		boolean isCourse=false;
		
		for(Course c:cList)
		{
			if(c.getCourseId()==courseId)
			{
				isCourse=true;
				for(Learner ll:c.getLearnerList())
				{
					if(ll.getEnrollmentId()==enrollmentId)
					{
						if(c.getSessionCount()==ll.getAttendedSessionCount())
						{
							throw new MaxSessionAttendedException("Maximum session was attended");
						}
						
						ll.setAttendedSessionCount(ll.getAttendedSessionCount()+1);
						return true;
						
					}
					
				}
				throw new LearnerNotFoundxception("Learner not available");
			}
		}
		if(isCourse==false)
		{
			throw new CourseNotFoundException("Course not found");
		}
		return false;
	}

}
