package com.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.bean.Course;
import com.bean.Learner;
import com.bean.NonTechnical;
import com.bean.Technical;
import com.exception.CourseNotFoundException;
import com.exception.LearnerAlreadyExistException;
import com.exception.LearnerNotFoundxception;
import com.exception.MaxSessionAttendedException;
import com.exception.LearnerNotFoundxception;


public class Tester {

	public static void main(String[] args) {
		
		Course c1 = new Course(101,"Java",5);
		Course c2 = new Course(102,"Oracle",11);
		Course c3 = new Course(103,"PHP",7);
		Course c4 = new Course(104,"DBMS",10);
		
		Course c5 = new NonTechnical(111, "Ethics", 15);
		Course c6 = new NonTechnical(112, "History", 15);
		Course c7 = new NonTechnical(113, "Values", 15);
		
		ArrayList<Course> courses = new ArrayList<Course>();
		
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);
		courses.add(c5);
		courses.add(c6);
		courses.add(c7);
		
		ElearningManagementSystem e = new ElearningManagementSystem();
		e.setcList(courses);
		
		Learner l1 = new Learner(1,"Amit",22,14);
		Learner l2 = new Learner(2,"Atul",23,15);
		
		
		//1st Method
		try {
			if(e.addLearner(111, l1))
			{
				System.out.println("Learner added successfully!!");
			}
		} catch (LearnerAlreadyExistException e1) {
			System.out.println(e1);
			
		} catch (CourseNotFoundException e1) {
			System.out.println(e1);
		}
		
		try {
			if(e.addLearner(111, l2))
			{
				System.out.println("Learner added successfully");
			}
		} catch (LearnerAlreadyExistException e1) {
			System.out.println(e1);
		} catch (CourseNotFoundException e1) {
			System.out.println(e1);
		}
		
		System.out.println("---------------");
		//2nd Method
		HashMap<Course,Integer> completedLearners = new HashMap<Course,Integer>();
		completedLearners = e.getLearnersCount();
		
		for(Map.Entry<Course, Integer> mp:completedLearners.entrySet())
		{
			System.out.println(mp.getKey().getCourseName()+" "+mp.getValue());
		}
		System.out.println("---------------");
		//3rd Method
		
		ArrayList<Course> nonTechnical = new ArrayList<Course>();
		nonTechnical = e.getNonTechnicalCourses(3);
		
		//decending order
		//Collections.sort(nonTechnical,(co1,co2)->(co2.getCourseName().compareTo(co1.getCourseName())));
		
		//ascending order using lambda expression
		Collections.sort(nonTechnical,(co1,co2)->(co1.getCourseName().compareTo(co2.getCourseName())));
		
		for(Course c:nonTechnical)
		{
			System.out.println(c.getCourseName()+" "+c.getCourseId());
		}
		
		System.out.println("--------------");
		
		//4th method
		
		try {
			if(e.updateAttendence(111, 1))
			{
				System.out.println("Attendance updated");
			}
		} catch (LearnerNotFoundxception e1) {
			System.out.println(e1);
		} catch (MaxSessionAttendedException e1) {
			System.out.println(e1);
		} catch (CourseNotFoundException e1) {
			System.out.println(e1);
		}
		

	


	}

}
