package com.springboot_course.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
	implements ConstraintValidator<CourseCode, String> {
	private String coursePrefix;

	// in our case, what we passed to the Annotation @CourseCode(value="LUV", message="must start with LUV") that saves for now what prefix we'll be looking out for.
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
	boolean result;
	if (theCode != null){
		result = theCode.startsWith(coursePrefix);
	}else{
		result = true;
	}
	return result;
	}
}
