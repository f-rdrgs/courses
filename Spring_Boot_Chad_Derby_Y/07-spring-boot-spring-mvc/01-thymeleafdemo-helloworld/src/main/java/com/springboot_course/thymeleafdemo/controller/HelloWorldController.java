package com.springboot_course.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    //Show initial HTML form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // Controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("processFormVersionTwo")
	// Servlet contains our form data
    public String letsShoudDude(HttpServletRequest request, Model model) {

        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "Yo! " + theName;

        // we add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

	@PostMapping ("processFormVersionThree")
	// Servlet contains our form data
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

        theName = theName.toUpperCase();

        String result = "Hey! " + theName;

        // we add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
