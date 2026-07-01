package com.springboot_course.mvc;

import com.springboot_course.mvc.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;
    
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName;

    @NotNull(message="is required")
    @Min(value=0, message="must be greater than or equal to zero")
    @Max(value=10, message="must be less than or equal to 10")
    // We used the Integer wrapper class so that it can handle having NULL as given by the whitspace trimmer
    private Integer freePasses;

    @CourseCode(value="TOPS",message="code must contain TOPS")
    private String courseCode;

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
    private String postalCode;
    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Customer() {
        super();
    }
}
