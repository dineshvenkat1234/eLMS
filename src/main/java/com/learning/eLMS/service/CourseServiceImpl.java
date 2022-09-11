package com.learning.eLMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.eLMS.model.Course;
import com.learning.eLMS.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

	//@Autowired
	//CourseRepository courseRepository;
	
	@Autowired
	CourseRepo courseRepository;
	
	@Override
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public boolean deleteCourse(String courseName) {
		Course course= courseRepository.findCourseByName(courseName);
		System.out.println("Course Name from table "+course.getName());
		courseRepository.delete(course);
		return true;
	}

	@Override
	public List<Course> getCourseByTechnology(String technology) {
		return courseRepository.findCourseByTechnology(technology);
	}

}
