package com.bridgelabz.EmployeePayrollApplication.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private String name;
    private double salary;
    private String department;
    private String gender;
    private String startDate;
    private String note;
    private String profilePic;
}
