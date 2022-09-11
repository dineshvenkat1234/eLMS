package com.learning.eLMS.repository;

import org.junit.Test;

import com.learning.eLMS.service.CourseService;
import com.learning.eLMS.service.CourseServiceImpl;

import static org.junit.Assert.*;

import org.junit.Before;

public class CourseServiceImplTest {

	CourseService courseService;
	
	@Before
	public void load() {
		courseService= new CourseServiceImpl();
	}
	
	@Test
	public void deleteCourseTest() {
		assertNotNull(courseService.deleteCourse("Python for SD3"));
	}
}
