package com.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define endpoint for "/student"
	@GetMapping("/students")
	public List<Student> getStudent() {

		List<Student> theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Hardik", "Khanna"));
		theStudents.add(new Student("Oshin", "Dhaliwal"));

		return theStudents;
	}

}
