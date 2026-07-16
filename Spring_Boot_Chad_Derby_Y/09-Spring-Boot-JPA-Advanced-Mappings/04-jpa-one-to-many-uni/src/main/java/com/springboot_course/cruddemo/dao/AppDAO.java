package com.springboot_course.cruddemo.dao;

import java.util.List;

import com.springboot_course.cruddemo.entity.Course;
import com.springboot_course.cruddemo.entity.Instructor;
import com.springboot_course.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update (Course tempCourse);

    Course findCourseById(int theId);

    void deleteCourseByid(int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId); 
    
}
