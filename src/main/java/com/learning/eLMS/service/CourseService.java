package com.learning.eLMS.service;

import java.util.List;

import com.learning.eLMS.model.Course;

public interface CourseService {

	public Course addCourse(Course course);
	
	public List<Course> getAllCourses();
	
	public boolean deleteCourse(String courseName);

	public List<Course> getCourseByTechnology(String technology);
}
