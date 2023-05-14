package com.ahmadSamir.newProgram.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @NotEmpty(message = "EmployeeCode shouldn't be empty")
    private String employeeCode;
    private  String employeeName;
    private String employeeAddress;
}
