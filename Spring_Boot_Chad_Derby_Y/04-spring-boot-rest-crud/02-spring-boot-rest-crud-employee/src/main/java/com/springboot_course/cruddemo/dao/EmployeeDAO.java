package com.springboot_course.cruddemo.dao;

import java.util.List;

import com.springboot_course.cruddemo.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theid);
}
