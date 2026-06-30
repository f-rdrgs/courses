package com.springboot_course.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot_course.thymeleafdemo.model.Student;

@Controller
public class StudentController {
    
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${os}")
    private List<String> os;
    
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
        
        Student theStudent = new Student();
        
        theModel.addAttribute("student",theStudent);

        // add the list to the model
        theModel.addAttribute("countries", countries);

        theModel.addAttribute("languages", languages);

        theModel.addAttribute("os", os);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        // Spring already gathers and defines the Student object's fields since we already specified it in the HTML

        System.out.println("theStudent:" + theStudent.getFirstName() + " " + theStudent.getLastName() + " " + theStudent.getCountry());
        
        return "student-confirmation";
    }
}
