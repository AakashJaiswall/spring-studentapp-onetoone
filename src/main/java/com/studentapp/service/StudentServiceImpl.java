//package com.studentapp.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.studentapp.model.Student;
//import com.studentapp.repository.IStudentRepository;
//@Service
//public class StudentServiceImpl implements IStudentService{
//	
//	private IStudentRepository studentRepository;
//	
//	@Autowired
//	public void setStudentRepository(IStudentRepository studentRepository) {
//		this.studentRepository = studentRepository;
//	}
//	
//	@Override
//	public void addStudent(Student student) {
//	studentRepository.save(student);
//	}
//
//	@Override
//	public void updateStudent(Student student) {
//	studentRepository.save(student);
//	}
//
//	@Override
//	public void deleteStudent(int studentId) {
//	studentRepository.deleteById(studentId);
//	}
//
//	@Override
//	public Student getById(int studentId) {
//		return studentRepository.findById(studentId).get();
//	}
//
//	@Override
//	public List<Student> getAll() {
//		return studentRepository.findAll();
//	}
//
//	@Override
//	public List<Student> getByDepartment(String department) {
//		return studentRepository.findByDepartment(department);
//	}
//
//}



package com.studentapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.studentapp.model.Student;
import com.studentapp.repository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        if (student.getStudentId() != null && studentRepository.existsById(student.getStudentId())) {
            studentRepository.save(student);
        }
        // Consider handling the case where the student doesn't exist, perhaps throwing an exception
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student getById(Integer studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        return studentOptional.orElse(null); // Alternatively, handle this with a custom exception or action
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getByDepartment(String department) {
        return studentRepository.findByDepartment(department);
    }
}
