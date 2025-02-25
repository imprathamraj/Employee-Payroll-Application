package com.bridgelabz.EmployeePayrollApplication.service;

import com.bridgelabz.EmployeePayrollApplication.model.Employee;
import com.bridgelabz.EmployeePayrollApplication.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    // Save the employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // To get all the employees
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    // To get the employee by id
    public Optional<Employee> getEmployeeById(Long id) {
        // Try block
        try {
            return employeeRepository.findById(id);
        }
        // Catch block
        catch (Exception e) {
            logger.error("Error finding employee with ID {}", id, e);
            return Optional.empty();
        }
    }

    // Update the employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        // Try block
        try {
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);
            if (optionalEmployee.isPresent()) {
                logger.info("Updating employee with ID: {}", id);
                Employee employee = optionalEmployee.get();
                employee.setName(updatedEmployee.getName());
                employee.setDepartment(updatedEmployee.getDepartment());
                employee.setSalary(updatedEmployee.getSalary());

                return employeeRepository.save(employee);
            } else {
                logger.warn("No employee found with ID: {}", id);
                return null;
            }
        }
        // Catch block
        catch (Exception e) {
            logger.error("An unexpected error occurred while updating employee with ID: {}", id, e);
            return null;
        }
    }

    // Delete employee
    public boolean deleteEmployee(Long id) {
        // Try block
        try {
            employeeRepository.deleteById(id);
            logger.info("Deleted employee with ID: {}", id);
        }
        // Catch block
        catch (Exception e) {
            logger.error("Error deleting employee with ID: {}", id, e);
        }
        return false;
    }
}
