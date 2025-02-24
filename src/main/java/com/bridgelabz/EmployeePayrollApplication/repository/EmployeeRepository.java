package com.bridgelabz.EmployeePayrollApplication.repository;

import com.bridgelabz.EmployeePayrollApplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

