package com.springboot_course.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot_course.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
