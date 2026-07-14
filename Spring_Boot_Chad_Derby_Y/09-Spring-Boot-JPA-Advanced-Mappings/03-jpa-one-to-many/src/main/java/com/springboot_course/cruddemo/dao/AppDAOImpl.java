package com.springboot_course.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot_course.cruddemo.entity.Course;
import com.springboot_course.cruddemo.entity.Instructor;
import com.springboot_course.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AppDAOImpl implements AppDAO{

    private  EntityManager entityManager;


    // Optional since we only have one CTOR
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor); // Because of the cascade param, both objects will be saved at once!
        
    }



    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class,theId);
    }



    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        List<Course> courses = tempInstructor.getCourses();

        // We make sure to disassociate the related instructor from all of his courses so that they also don't get deleted.
        for (Course tempCourse : courses){
            tempCourse.setInstructor(null);
        }

        entityManager.remove(tempInstructor);
    }



    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }



    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);

        query.setParameter("data",theId);

        List<Course> courses = query.getResultList();

        return courses;
    }



    // This allows us to get all the classes EVEN WITH LAZY LOADING and as such, we don't need a 2nd query in the main program to get them. We also add JOIN FETCH for instructorDetail so we need less individual requests.
    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail where i.id = :data",Instructor.class);

        query.setParameter("data", theId);

        Instructor instructor = query.getSingleResult();

        return instructor;
    }



    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        // Updates existing entity
        entityManager.merge(tempInstructor);
    }



    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }



    @Override
    @Transactional
    public void update(Course tempCourse) {
       entityManager.merge(tempCourse);
    }



    @Override
    public void deleteCourseByid(int theId) {
        Course tempCourse = entityManager.find(Course.class, theId);

        entityManager.remove(tempCourse);
    }
    
    
    

}
