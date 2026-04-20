
package org.springframework.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.springcoredemo.common.Coach;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Private field for dependecy
    private Coach myCoach;

    @Autowired
    public void summonTheCoach(Coach theCoach){
        myCoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
