package com.ahmadSamir.newProgram.service;

import com.ahmadSamir.newProgram.dto.EmployeeDto;
import com.ahmadSamir.newProgram.models.Employee;
import com.ahmadSamir.newProgram.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
//    @Override
//    public void addEmployee(EmployeeDto employeeDto) {
//        employeeRepository.save(mapToEmployee(employeeDto));
//    }
    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


//    @Override
//    public List<EmployeeDto> getAllEmployees() {
//        List<Employee> employees = employeeRepository.findAll();
//        return employees.stream().map(employee -> mapEmployeeToEmployeeDto(employee)).collect(Collectors.toList());
//    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
        //return employees.stream().map(employee -> mapEmployeeToEmployeeDto(employee)).collect(Collectors.toList());
    }

//    @Override
//    public EmployeeDto getEmployeeById(int id) throws IllegalArgumentException{
//        Optional<Employee> employee =  employeeRepository.findById(id);
//        if( employee.isPresent() ){
//            return mapEmployeeToEmployeeDto(employee.get());
//        }
//        else{
//            throw new  IllegalArgumentException();
//        }
//    }
    @Override
    public Employee getEmployeeById(int id) throws IllegalArgumentException{
        Optional<Employee> employee =  employeeRepository.findById(id);
        if( employee.isPresent() ){
            return employee.get();
        }
        else{
            throw new  IllegalArgumentException();
        }
    }

//    @Override
//    public void deleteEmployeeById(int id) throws IllegalArgumentException{
//        EmployeeDto employeeDto = getEmployeeById(id);
//        employeeRepository.deleteById(id);
//    }
    @Override
    public void deleteEmployeeById(int id) throws IllegalArgumentException{
        Employee employee = getEmployeeById(id);
        employeeRepository.deleteById(id);
    }

//    @Override
//    public void updateEmployeeById(int id , EmployeeDto employeeDto) throws IllegalArgumentException{
//        Employee exiEmployee = employeeRepository.findById(id).get();
//        exiEmployee.setEmployeeCode(employeeDto.getEmployeeCode());
//        exiEmployee.setEmployeeName(employeeDto.getEmployeeName());
//        exiEmployee.setEmployeeAddress(employeeDto.getEmployeeAddress());
//        employeeRepository.save(exiEmployee);
//    }
    @Override
    public void updateEmployeeById(int id , Employee employee) throws IllegalArgumentException{
        Employee exiEmployee = getEmployeeById(id);
        exiEmployee.setEmployeeCode(employee.getEmployeeCode());
        exiEmployee.setEmployeeName(employee.getEmployeeName());
        exiEmployee.setEmployeeAddress(employee.getEmployeeAddress());
        employeeRepository.save(exiEmployee);
    }
//
//    @Override
//    public EmployeeDto getEmployeeByEmployeeCode(String employeeCode) throws IllegalArgumentException{
//        Optional<Employee> employee =  employeeRepository.findByEmployeeCode(employeeCode);
//        if( employee.isPresent() ){
//            return mapEmployeeToEmployeeDto(employee.get());
//        }
//        else{
//            throw new IllegalArgumentException();
//        }
//
//    }

    @Override
    public Optional<Employee>  getEmployeeByEmployeeCode(String employeeCode) throws IllegalArgumentException{
        Optional<Employee> employee =  employeeRepository.findByEmployeeCode(employeeCode);
        return  employee;
//        if( employee.isPresent() ){
//            return employee.get();
//        }
//        else{
//            throw new IllegalArgumentException();
//        }

    }
}
