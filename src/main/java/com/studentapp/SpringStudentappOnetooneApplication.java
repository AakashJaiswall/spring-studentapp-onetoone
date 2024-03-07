package com.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.Address;
import com.studentapp.model.Student;
import com.studentapp.repository.IStudentRepository;
import com.studentapp.service.IStudentService;

@SpringBootApplication
public class SpringStudentappOnetooneApplication implements CommandLineRunner{

	private IStudentService studentService;

	@Autowired
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringStudentappOnetooneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("Shujalpur","MP");
		Student student = new Student("Shivam","CSE", address);
		studentService.addStudent(student);
	
//	Student nstudent = studentService.getById(2);
//	//set the department
//	nstudent.setDepartment("Civil");
//	
//	//call update method
//	
//	studentService.updateStudent(nstudent);
//	System.out.println(nstudent);
		
		studentService.getByDepartment("CSE").forEach(System.out::println);
	}
}
