package com.springboot_course.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.springboot_course.thymeleafdemo.model.Student;

@Controller
public class StudentController {
    
    public String showForm(Model theModel){
        
        Student theStudent = new Student();
        
        theModel.addAttribute("student",theStudent);
        
        return "student-form";
    }
}
