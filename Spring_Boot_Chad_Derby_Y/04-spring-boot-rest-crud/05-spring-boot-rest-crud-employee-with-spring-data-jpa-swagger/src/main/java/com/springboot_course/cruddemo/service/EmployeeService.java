package com.springboot_course.cruddemo.service;

import java.util.List;

import com.springboot_course.cruddemo.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theid);
}
