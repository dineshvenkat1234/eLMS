package com.learning.eLMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.learning.eLMS.controller.AuthConsumerController;
import com.learning.eLMS.filter.CourseJWTFilter;

@SpringBootApplication
public class ELmsApplication {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean fb = new FilterRegistrationBean();
		fb.setFilter(new CourseJWTFilter());
		fb.addUrlPatterns("/api/v1.0/*");
		return fb;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ELmsApplication.class, args);
	}

	
}
