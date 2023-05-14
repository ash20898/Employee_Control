package com.ahmadSamir.newProgram.mapper;

import com.ahmadSamir.newProgram.dto.EmployeeDto;
import com.ahmadSamir.newProgram.models.Employee;

public class EmployeeMapper {

    private Employee mapToEmployee(EmployeeDto employeeDto)
    {
        Employee employee = Employee.builder()
                .employeeId(employeeDto.getEmployeeId())
                .employeeCode(employeeDto.getEmployeeCode())
                .employeeAddress(employeeDto.getEmployeeAddress())
                .employeeName(employeeDto.getEmployeeName())
                .build();
        return employee;
    }

    private EmployeeDto mapEmployeeToEmployeeDto(Employee employee)
    {
        EmployeeDto employeeDto = EmployeeDto.builder()
                .employeeId(employee.getEmployeeId())
                .employeeCode(employee.getEmployeeCode())
                .employeeName(employee.getEmployeeName())
                .employeeAddress(employee.getEmployeeAddress())
                .build();
        return employeeDto;
    }

}
