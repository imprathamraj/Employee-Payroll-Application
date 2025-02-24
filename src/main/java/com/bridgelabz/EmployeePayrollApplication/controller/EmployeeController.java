package com.bridgelabz.EmployeePayrollApplication.controller;


import com.bridgelabz.EmployeePayrollApplication.model.Employee;
import com.bridgelabz.EmployeePayrollApplication.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;
    //To get all the employees
    @GetMapping
    public List<Employee> getAllEmployees(){
        logger.info("All employee endpoint called");
        return employeeService.getAllEmployee();
    }

    //TO get employee with id
    @GetMapping("/get/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        logger.info("By id employee endpoint called");
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public Employee addEmployee(@RequestBody Employee employee){
        logger.info("Create employee endpoint called");
        return employeeService.addEmployee(employee);
    }

    //Update the employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        logger.info("Update employee endpoint called");
        return employeeService.updateEmployee(id,employee);
    }

    //Delete the employee
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        logger.info("Delete employee endpoint called");
        employeeService.deleteEmployee(id);
    }

}