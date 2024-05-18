package com.jaysurya.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaysurya.entity.Course;
import com.jaysurya.entity.Student;
import com.jaysurya.repository.CourseRepository;
import com.jaysurya.repository.StudentRepository;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

	private StudentRepository studentRepository;

	private CourseRepository courseRepository;

	public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}
	
	
	@PostMapping
	public Student saveStudentWithCourse(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@GetMapping
	public List<Student> findAllStudent(){
		return studentRepository.findAll();
	}
	
	@GetMapping("/{studentId}")
	public Student findStudent(@PathVariable Long studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}
	
	@GetMapping("/{name}")
	public List<Student> findStduentsConatiningName(@PathVariable String name){
		return studentRepository.findByNameContaining(name);
	}
	
	@GetMapping("/search/{price}")
	public List<Course> findCourseLessThanPrice(@PathVariable double price){
		return courseRepository.findByFeesLessThan(price);
		
	}
}
