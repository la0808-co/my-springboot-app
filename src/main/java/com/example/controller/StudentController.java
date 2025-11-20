package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entities.Student;
import com.crud.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentController {

    @Autowired
    StudentService studentService;

    // Save using URL Path Variables
    @PostMapping("/save/{name}/{age}/{dept}")
    public String save(@PathVariable String name,
                       @PathVariable String age,
                       @PathVariable String dept) {

        System.out.println("Saving student using path variables...");

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setDept(dept);

        studentService.saveStudent(student);

        return "Student Saved Successfully!";
    }

    @GetMapping("/getall")
    public java.util.List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @DeleteMapping("/deletestudent/{id}")
    public String deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return "Student Deleted Successfully!";
    }
}
