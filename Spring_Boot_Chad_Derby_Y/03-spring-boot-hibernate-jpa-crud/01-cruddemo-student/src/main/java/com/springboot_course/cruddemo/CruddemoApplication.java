package com.springboot_course.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot_course.cruddemo.dao.StudentDAO;
import com.springboot_course.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);		

			// deleteAllStudents(studentDAO);
		};
    }

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleted "+studentDAO.deleteAll()+" students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 5;

		System.out.println("Deleting student id: "+studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Elli","Vance","half.life@gmail.com");
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();

		System.out.println("Saved student. Generated id: "+theId);
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent = studentDAO.findById(theId);
		System.out.println("Found my student pre-update: "+myStudent);

		tempStudent.setFirstName("Eli");
		studentDAO.update(tempStudent);
		
		myStudent = studentDAO.findById(theId);

		System.out.println("Found my student pre-update: "+myStudent);
		
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents =studentDAO.findByLastName("Van");

		for (Student tempsStudent : theStudents){
			System.out.println(tempsStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Alyx","Vance","half.life@gmail.com");
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();

		System.out.println("Saved student. Generated id: "+theId);
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found my student: "+myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 new student objects ...");

		Student tempStudent = new Student("Gordon","Freeman","half.life@gmail.com");
		Student tempStudent2 = new Student("Gordonon","Freeman","half.life2@gmail.com");
		Student tempStudent3 = new Student("Gordonyes","Freeman","half.life3@gmail.com");

		System.out.println("Saving the students ...");

		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");

		Student tempStudent = new Student("Gordon","Freeman","half.life@gmail.com");

		System.out.println("Saving the student ...");

		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}
}
