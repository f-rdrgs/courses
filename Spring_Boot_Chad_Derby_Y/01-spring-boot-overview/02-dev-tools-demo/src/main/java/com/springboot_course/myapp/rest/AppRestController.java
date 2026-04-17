package com.springboot_course.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

    @GetMapping("/")
    public String sayHello() {
    
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyworkout(){
        return "Run a hard 5k!";
        }

    @GetMapping("/fortune")
    public String getFortune(){
        return "Today's your lucky day!";
    }

}
