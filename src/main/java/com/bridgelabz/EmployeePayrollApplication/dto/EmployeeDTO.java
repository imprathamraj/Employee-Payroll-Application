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

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female only")
    private String gender;

    //Date is converted into LocalDate with @JsonFormat and pattern
    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "Start date should not be set empty")
    //Restricting to input only valid past or today's date
    @PastOrPresent(message = "Start date should be past or today's date")
    private String startDate;

    @NotBlank(message = "Note can not be set empty")
    private String note;

    @NotBlank(message = "profilePic can not be set empty")
    private String profilePic;

    @NotNull(message = "Department can not be set empty!")
    private String department;
}
