package com.bridgelabz.EmployeePayrollApplication.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$")
    @Size(min=2, message = "Name should have atleast 2 characters")
    private String name;

    @NotNull(message = "Salary can not be null!")
    @Min(value = 10000, message = "Salary should be minimum 10,000")
    private double salary;

    @NotBlank(message = "Department can not be set empty!")
    @Size(min=5, message = "Salary should have atleast 5 characters")
    private String department;
    private String gender;
    private String startDate;
    private String note;
    private String profilePic;
}
