package com.learning.eLMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.eLMS.model.Course;

public interface CourseRepository {

	@Query("select c from Course c where c.name= :name")
	public Course findCourseByName(@Param("name") String name);

	@Query("select c from Course c where c.technology= :technology")
	public List<Course> findCourseByTechnology(String technology);
}
