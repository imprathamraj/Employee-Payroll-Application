package com.bridgelabz.EmployeePayrollApplication.service;

import com.bridgelabz.EmployeePayrollApplication.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApplication.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    List<Employee> getEmployee();

    Employee getEmployeeById(int id);

    List<Employee> getEmployeeByDepartment(List<String> department);

    Employee addEmployee(EmployeeDTO employeeDTO);

    void deleteEmployee(int id);
}
