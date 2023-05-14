package com.ahmadSamir.newProgram.service;


import com.ahmadSamir.newProgram.dto.EmployeeDto;
import com.ahmadSamir.newProgram.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

     void addEmployee(Employee employee);
     List<Employee> getAllEmployees();
     Employee getEmployeeById(int id);
     void deleteEmployeeById(int id);
     void updateEmployeeById(int id , Employee employeeDto);
     Optional<Employee>  getEmployeeByEmployeeCode (String employeeCode);
}
