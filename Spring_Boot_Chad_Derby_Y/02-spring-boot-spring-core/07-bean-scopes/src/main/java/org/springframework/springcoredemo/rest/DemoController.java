package org.springframework.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.springcoredemo.common.Coach;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Private field for dependecy
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    //First char has to be lowercase!
    public DemoController(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theOtherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theOtherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach, "+ ((myCoach==anotherCoach) ? "same Beans": "Different beans");
    }
}
