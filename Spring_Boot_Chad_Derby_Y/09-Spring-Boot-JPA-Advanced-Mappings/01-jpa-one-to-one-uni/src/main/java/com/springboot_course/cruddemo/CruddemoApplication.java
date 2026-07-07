package com.springboot_course.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot_course.cruddemo.dao.AppDAO;
import com.springboot_course.cruddemo.entity.Instructor;
import com.springboot_course.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            // createInstructor(appDAO);
            // findInstructor(appDAO);
            // deleteInstructor(appDAO);
            findInstructorDetail(appDAO);
        };
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
