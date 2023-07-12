package com.takeo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.takeo.entity.Course;
import com.takeo.service.impl.CourseServiceImpl;

@RestController
public class CourseController {
	//from the controller interact with the service impl layer 
	@Autowired
	private CourseServiceImpl cService;
	 //add the courses//Save the courses//register courses
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid @RequestBody Course course)
	{
		String msg = cService.saveCourse(course);
		
		return ResponseEntity.ok(HttpStatus.OK).ok(msg);
	}
	
	@GetMapping("/viewAll")
	public List<Course> getCourses()
	{
		List<Course> viewAllCourse = cService.viewAllCourse();
		return viewAllCourse;
	}
	
	@GetMapping("/viewC")
	public List<String> courseNames()
	{
		List<String> viewCourseNames = cService.viewCourseNames();
		return viewCourseNames;
	}
	
	@PutMapping("/update")
	public String updateCourseInfo(@RequestBody Course course)
	{
		String updateCourse=cService.updateCourse(course);
		return updateCourse;
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Integer id)
	{
		Course getCourse = cService.getCourseInfo(id);
		
		 if(getCourse!=null) 
			return ResponseEntity.ok(HttpStatus.OK).ok(getCourse);
		  else 
			  return ResponseEntity.ok(HttpStatus.NOT_FOUND).ok(getCourse);
		 
		
		
	}
	
	

}
