package com.bridgelabz.EmployeePayrollApplication.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotBlank(message = "Name can not be empty!")
    @Size(min=2, message = "Name should have atleast 2 characters")
    private String name;

    @NotNull(message = "Salary can not be null!")
    @Min(value = 10000, message = "Salary should be minimum 10,000")
    private double salary;

    @NotBlank(message = "Department can not be set empty!")
    @Size(min=5, message = "Salary should have atleast 5 characters")
    private String department;
}
