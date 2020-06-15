package com.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	// define @PostContruct to load the Student Data

	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Hardik", "Khanna"));
		theStudents.add(new Student("Oshin", "Dhaliwal"));
		theStudents.add(new Student("Oshin", "Dhaliwal"));
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if (studentId >= theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("Student Id not Found - " + studentId);
		}

		return theStudents.get(studentId);

	}

	// define endpoint for "/student"
	@GetMapping("/students")
	public List<Student> getStudent() {

		return theStudents;
	}

}
