package com.studentapp.service;

import java.util.List;

import com.studentapp.model.Student;

public interface IStudentService {

	void addStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(Integer studentId);
	Student getById(Integer studentId);


	
	List<Student> getAll();
	List<Student> getByDepartment(String department);
}
