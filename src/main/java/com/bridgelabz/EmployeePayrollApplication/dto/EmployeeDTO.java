package com.bridgelabz.EmployeePayrollApplication.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    private String name;

    @Min(value = 10000, message = "Salary should be minimum 10,000")
    private double salary;

    private String gender;

    private String startDate;

    private String note;

    private String profilePic;

    private String department;
}
