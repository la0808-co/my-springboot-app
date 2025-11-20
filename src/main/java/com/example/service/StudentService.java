package com.example.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entities.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public String saveStudent(Student std)
	{
		studentRepository.save(std);
		return null;
	}
	
	public List<Student> getAllStudent()
	{
		return studentRepository.findAll();
	}
	
	public void deleteStudent(long id)
	{
		studentRepository.deleteById(id);
	}

}
