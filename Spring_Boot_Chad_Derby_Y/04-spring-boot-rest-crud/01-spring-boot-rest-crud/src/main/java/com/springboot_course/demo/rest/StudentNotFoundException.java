package com.springboot_course.demo.rest;

public class StudentNotFoundException extends  RuntimeException {

    // All of it is executed as a kind of interface to RuntimeException, just passing along our own values to it
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    
}
