package com.ahmadSamir.newProgram.controller;

import com.ahmadSamir.newProgram.dto.EmployeeDto;
import com.ahmadSamir.newProgram.models.Employee;
import com.ahmadSamir.newProgram.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String HomePage(Model model)
    {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmployees",allEmployees);
        return "HomePage";
    }
    @GetMapping("/EmployeeForm")
    public String EmployeeForm(Model model)
    {
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "EmployeeForm";
    }
    @PostMapping("/saveEmployee")
    public String addNewEmployee(@Valid @ModelAttribute("employee") Employee employee,
                                     BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "EmployeeForm";
        }
        Optional<Employee> exEmployee = employeeService.getEmployeeByEmployeeCode(employee.getEmployeeCode());
        if(  exEmployee.isPresent() ){
            return "EmployeeForm";
        }
        employeeService.addEmployee(employee);
        return "redirect:/";

    }
    @GetMapping("/DeleteEmployee/{employeeId}")
    public String DeleteTrain(@PathVariable("employeeId") int employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return "redirect:/";
    }
}
