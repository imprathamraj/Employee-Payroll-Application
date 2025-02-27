package com.bridgelabz.EmployeePayrollApplication.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    private String message;
    private String details;
    private LocalDateTime timestamp;

    public ErrorResponseDTO(String message, String s) {
        this.message = message;
        this.details = s;
        this.timestamp = LocalDateTime.now();
    }
}
