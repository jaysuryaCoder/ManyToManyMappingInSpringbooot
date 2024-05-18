package com.jaysurya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaysurya.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	List<Course>findByFeesLessThan(double fees);
}
