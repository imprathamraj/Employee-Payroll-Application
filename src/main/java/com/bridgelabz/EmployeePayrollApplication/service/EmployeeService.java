package com.bridgelabz.EmployeePayrollApplication.service;

import com.bridgelabz.EmployeePayrollApplication.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApplication.model.Employee;
import com.bridgelabz.EmployeePayrollApplication.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Save the employee
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setNote(employeeDTO.getNote());
        employee.setProfilePic(employeeDTO.getProfilePic());
        employee.setDepartment(employeeDTO.getDepartment());
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
            log.error("Error finding employee with ID {}", id, e);
            return Optional.empty();
        }
    }

    // Update the employee
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        // Try block
        try {
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);
            if (optionalEmployee.isPresent()) {
                log.info("Updating employee with ID: {}", id);
                Employee employee = optionalEmployee.get();
                employee.setName(employeeDTO.getName());
                employee.setSalary(employeeDTO.getSalary());
                employee.setGender(employeeDTO.getGender());
                employee.setStartDate(employeeDTO.getStartDate());
                employee.setNote(employee.getNote());
                employee.setProfilePic(employee.getProfilePic());
                employee.setDepartment(employeeDTO.getDepartment());
                return employeeRepository.save(employee);
            } else {
                log.warn("No employee found with ID: {}", id);
                return null;
            }
        }
        // Catch block
        catch (Exception e) {
            log.error("An unexpected error occurred while updating employee with ID: {}", id, e);
            return null;
        }
    }

    // Delete employee
    public boolean deleteEmployee(Long id) {
        // Try block
        try {
            employeeRepository.deleteById(id);
            log.info("Deleted employee with ID: {}", id);
            return true;
        }
        // Catch block
        catch (Exception e) {
            log.error("Error deleting employee with ID: {}", id, e);
            return false;
        }
    }
}
