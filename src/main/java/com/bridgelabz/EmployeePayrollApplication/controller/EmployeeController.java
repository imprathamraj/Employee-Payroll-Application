package com.bridgelabz.EmployeePayrollApplication.controller;

import com.bridgelabz.EmployeePayrollApplication.model.Employee;
import com.bridgelabz.EmployeePayrollApplication.service.EmployeeService;
import com.bridgelabz.EmployeePayrollApplication.dto.EmployeeDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // To get all the employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        log.info("All employee endpoint called");
        return employeeService.getAllEmployee();
    }

    // To get employee by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id ) {
        log.info("By ID employee endpoint called with ID: {}", id);
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee);
        } else {
            log.warn("No employee found with ID: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
    }

    // To create a new employee
    @PostMapping("/create")
    public Employee addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Create employee endpoint called");
        return employeeService.addEmployee(employeeDTO);
    }

    // To update the employee
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Update employee endpoint called with ID: {}", id);
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            log.warn("No employee found with ID: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // To delete the employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        log.info("Delete employee endpoint called with ID: {}", id);
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            log.warn("No employee found with ID: {} to delete", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
