package org.springframework.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
 public class CricketCoach implements Coach{

    public CricketCoach() {
        super();
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define init method
    @PostConstruct
    public void startupStuff(){
        System.out.println("Starting up!!!!!! "+getClass().getSimpleName());
    }

    // define destroy method, it executes this when app is shutting down for ex
    @PreDestroy
    public void destroyStuff(){
        System.out.println("I'm packing up!!!!!! "+getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 17 minutes";
    }
    
}
