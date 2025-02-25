package com.bridgelabz.EmployeePayrollApplication.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotNull
    @Size(min=2, message = "Name should have atleast 2 characters")
    private String name;

    @NotNull
    @Size(min=2, message = "Salary should have atleast 2 characters")
    private double salary;

    @NotNull
    @Size(min=5, message = "Salary should have atleast 5 characters")
    private String department;
}
