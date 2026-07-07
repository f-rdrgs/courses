package com.springboot_course.cruddemo.dao;

import com.springboot_course.cruddemo.entity.Instructor;
import com.springboot_course.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);
}
