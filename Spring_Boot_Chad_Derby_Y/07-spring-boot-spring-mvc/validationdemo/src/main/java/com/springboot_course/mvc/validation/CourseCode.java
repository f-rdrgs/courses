package com.springboot_course.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD} ) // Apply this annotation to a method or field
@Retention(RetentionPolicy.RUNTIME) // How long will the marked annotaiton be used for, processed at runtime here
public @interface CourseCode {

	// define default course code
	public String value() default "LUV";

	// define default error message
	public String message() default "must start with LUV";

    // define default groups (Groups: can group related constraints)
    public Class<?>[] groups() default {};

    // define default payloads Provides custom details about validation failure (severity level, error code, etc)
    public Class<? extends Payload>[] payload() default {};

}