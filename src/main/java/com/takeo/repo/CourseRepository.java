package com.takeo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.takeo.entity.Course;

@Repository

public interface CourseRepository extends JpaRepository<Course, Integer> {
// insert /update/retrieve/delete
	//predefined Methods to perform these operations
	//if we need  any other method we have to write in this
	//Repository like findxxx methods.
	
	
	//using courseName get the Specific Record
	Course findByCname(String cname);
	
	//get the courseNames
	@Query("select cname from Course")
	List<String> getCourseName();
	
}