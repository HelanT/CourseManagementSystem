package com.takeo.service;

import java.util.List;

import com.takeo.entity.Course;

public interface CourseService {
	//register the course into the database
	
	public String saveCourse(Course course);
	
	//to retrieve all the Courses
	public List<Course> viewAllCourse();
	
	//Retrieve courseNames
	public List<String> viewCourseNames();
	
	//update the course into the database(mySql)
	public String updateCourse(Course course);
	  
	//to fetch specific Record 
	public Course getCourseInfo(Integer id);

}
