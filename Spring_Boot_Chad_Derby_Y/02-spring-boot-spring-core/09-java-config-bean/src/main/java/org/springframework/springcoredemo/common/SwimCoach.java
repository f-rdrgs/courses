package org.springframework.springcoredemo.common;

public class SwimCoach implements Coach{


    public SwimCoach() {
        super();
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warmup";
    }

}
