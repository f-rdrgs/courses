package com.springboot_course.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_course.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Gordon", "Freeman"));
        theStudents.add(new Student("Alyx", "Vance"));
        theStudents.add(new Student("Eli", "Vance"));

        return theStudents;
    }
}
