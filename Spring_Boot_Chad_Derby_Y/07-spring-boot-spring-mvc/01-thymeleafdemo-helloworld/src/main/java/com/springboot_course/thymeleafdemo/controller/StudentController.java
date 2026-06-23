package com.springboot_course.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot_course.thymeleafdemo.model.Student;

@Controller
public class StudentController {
    
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
        
        Student theStudent = new Student();
        
        theModel.addAttribute("student",theStudent);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        // Spring already gathers and defines the Student object's fields since we already specified it in the HTML

        System.out.println("theStudent:" + theStudent.getFirstName() + " " + theStudent.getLastName());
        
        return "student-confirmation";
    }
}
