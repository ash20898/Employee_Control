package com.ahmadSamir.newProgram.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Employees" , uniqueConstraints = @UniqueConstraint(
        name = "employeeCode_unique",
        columnNames = "employeeCode"
))
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @NotEmpty(message = "employeeCode shouldn't be empty")
    @Column(name = "employeeCode" , unique = true )
    private String employeeCode;
    private  String employeeName;
    private String employeeAddress;
}
