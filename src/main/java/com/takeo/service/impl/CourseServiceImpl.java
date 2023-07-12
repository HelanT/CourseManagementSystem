package com.takeo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.entity.Course;
import com.takeo.repo.CourseRepository;
import com.takeo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	//from the service layer store the data into the database...
	//for this we required Repository Methods to perform 
	//JPA(insert/delete/update/retrieve)operations..
	
	@Autowired
	private CourseRepository cRepo;
	
	@Override
	public String saveCourse(Course course) {
		// TODO Auto-generated method stub
		//to store the data into the database
		Course c = cRepo.save(course);
		String msg="";
		if(msg!=null)
			msg="Registered Successfully";
		else
			msg="Request Denied! Try Again Later!";
		return msg;
	}

	@Override
	public List<Course> viewAllCourse() {
		// TODO Auto-generated method stub
		//to retrieve all the records from the database
		List<Course> viewAllCourse = cRepo.findAll();
		
		return viewAllCourse;
	}

	@Override
	public List<String> viewCourseNames() {
		// TODO Auto-generated method stub
		List<String> viewCourseName = cRepo.getCourseName();
		return viewCourseName;
	}

	@Override
	public String updateCourse(Course course) {
		// TODO Auto-generated method stub
		
		//to update the record we have to use save method only
		// No other options
		
		Course cUpdate = cRepo.save(course);
		String msg ="";
		if(msg!=null)
		   msg ="Course Updated Succesfully";
		else
			msg="Request Denied!";
		
		return msg;
	}

	@Override
	public Course getCourseInfo(Integer id) {
		// TODO Auto-generated method stub
		Optional<Course> course = cRepo.findById(id);
		Course c = course.get();
		
		return c;
	}

}
