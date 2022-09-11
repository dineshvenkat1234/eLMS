package com.learning.eLMS.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private String name;
	private String duration;
	private String description;
	private String technology;
	private String launchURL;
	
	public Course() {
		super();
	}

	public Course(int courseId, String name, String duration, String description, String technology, String launchURL) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.duration = duration;
		this.description = description;
		this.technology = technology;
		this.launchURL = launchURL;
	}
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getLaunchURL() {
		return launchURL;
	}
	public void setLaunchURL(String launchURL) {
		this.launchURL = launchURL;
	}
}
