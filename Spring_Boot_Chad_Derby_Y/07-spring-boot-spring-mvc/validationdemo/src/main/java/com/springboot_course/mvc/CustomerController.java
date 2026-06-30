package com.springboot_course.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CustomerController {

    @GetMapping("/showCustomer")
    public String showForm(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // This is available in the Spring API which removes whitespaces, and adding true makes it null if it's completely empty
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        // We add this editor to be used on the pre-processing
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {

        System.out.println("Last name: |"+theCustomer.getLastName()+"|");

        if (theBindingResult.hasErrors()) {
            return "customer-form";
        }

        return "customer-confirmation";

    }
}
