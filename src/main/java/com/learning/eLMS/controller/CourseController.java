package com.learning.eLMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.eLMS.model.Course;
import com.learning.eLMS.service.CourseService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1.0/lms")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/courses/getall")
	public ResponseEntity<?> getAllCourses() {
		List<Course> coursList = courseService.getAllCourses();
		if(coursList!=null && coursList.size()>0) {
			return new ResponseEntity<List<Course>>(coursList, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("No courses available",HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value="/courses/add",consumes = "application/json; charset=utf-8")
	public ResponseEntity<?> addCourse(@RequestBody Course course){
		if(courseService.addCourse(course)!=null) {
			return new ResponseEntity<Course>(course, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Data not inserted",HttpStatus.CONFLICT);
	}
	
	@DeleteMapping("/courses/delete/{name}")
	public ResponseEntity<?> deleteCourse(@PathVariable("name") String name){
		if(courseService.deleteCourse(name)) {
			return new ResponseEntity<String>("Course deleted.", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Cannt delete due to error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/courses/info/{technology}")
	public ResponseEntity<?> getCourseByTechnology(@PathVariable("technology") String technology){
		List<Course> courses= courseService.getCourseByTechnology(technology);
		if(courses!=null) {
			return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No courses available", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
