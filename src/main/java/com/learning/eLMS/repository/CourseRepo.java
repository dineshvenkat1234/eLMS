package com.learning.eLMS.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.learning.eLMS.model.Course;


public interface CourseRepo extends MongoRepository<Course, Integer>{


	@Query("{name : ?0}")
	public Course findCourseByName(String name);

	@Query("{technology : ?0}")
	public List<Course> findCourseByTechnology(String technology);
}
