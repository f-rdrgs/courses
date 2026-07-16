package com.springboot_course.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot_course.cruddemo.dao.AppDAO;
import com.springboot_course.cruddemo.entity.Course;
import com.springboot_course.cruddemo.entity.Instructor;
import com.springboot_course.cruddemo.entity.InstructorDetail;
import com.springboot_course.cruddemo.entity.Review;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {

            // createCourseAndReviews(appDAO);
            // retrieveCourseAndReviews(appDAO);
            deleteCourseAndReviews(appDAO);
        };
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
       int theId = 10;

       System.out.println("Deleting course id: "+theId);

       appDAO.deleteCourseByid(theId);

       System.out.println("Done.");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {

        int theId = 10;

        Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
        
        System.out.println(tempCourse);

        System.out.println(tempCourse.getReviews());
    }

    private void createCourseAndReviews(AppDAO appDAO) {
       Course tempCourse = new Course("How to capture a vantage point");

       tempCourse.addReview(new Review("Short, concise, great."));
       tempCourse.addReview(new Review("Just awesome man."));
       tempCourse.addReview(new Review("Didn't work, I got captured instead."));

       System.out.println("Saving the course");
       System.out.println(tempCourse);
       System.out.println(tempCourse.getReviews());
       
       appDAO.save(tempCourse);
    }

    private void updateCourse(AppDAO appDAO) {
       int theId = 10;

       System.out.println("Finding course id: "+theId);
       Course tempCourse = appDAO.findCourseById(theId);

       System.out.println("Updating course id: "+theId);
        tempCourse.setTitle("Facing off the Combine");
        appDAO.update(tempCourse);

        System.out.println("Done!");
    }

    private void updateInstructor(AppDAO appDAO) {
       int theId = 1;

        System.out.println("Finding instructor id: "+theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("Updating instructor id: "+ theId);

        tempInstructor.setLastName("Bananas");
        appDAO.update(tempInstructor);

        System.out.println("Done!");

    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
           int theId = 1;
      System.out.println("Finding instructor id: "+theId);

      Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

      System.out.println("tempInstructor: "+tempInstructor);
      System.out.println("the associated courses: "+tempInstructor.getCourses());

      System.out.println("Done!");   
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
      int theId = 1;
      System.out.println("Finding instrctor id: "+theId);

      Instructor tempInstructor = appDAO.findInstructorById(theId);

      // Since we're lazily loading, we have to make sure to get the courses manually and add it to the instructor object!
      List<Course> courses = appDAO.findCoursesByInstructorId(theId);

      tempInstructor.setCourses(courses);

      System.out.println("tempInstructor: "+tempInstructor);
      System.out.println("the associated courses: "+tempInstructor.getCourses());

      System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
    
        Instructor tempInstructor = new Instructor("Gordon", "Freeman", "blackmesa@gmail.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com", "Video Games");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Course tempCourse1 = new Course("How to de-beak a Headcrab");

        Course tempCourse2 = new Course("Gravity Gun - All you need to know");

        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        System.out.println("Saving instructor: "+tempInstructor);

        System.out.println("The courses: "+tempInstructor.getCourses());

        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor detail id: "+theId);

        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        System.out.println("tempInstructorDetail: "+tempInstructorDetail);
        System.out.println("The associated instructor: "+tempInstructorDetail.getInstructor());

    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        
        System.out.println("Deleting instructor id: "+theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: "+theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: "+tempInstructor);
        System.out.println("Associated Instructor details: "+tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {

        Instructor tempInstructor = new Instructor("Gordon", "Freman", "blackmesa@gmail.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Scientisting");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("Saving instructor: " + tempInstructor);

        // As said previously, thanks to the CascadeType.ALL, tempInstructorDetail will also be saved here
        appDAO.save(tempInstructor);
    }
}
