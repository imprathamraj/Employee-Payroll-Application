package com.bridgelabz.EmployeePayrollApplication.repository;

import com.bridgelabz.EmployeePayrollApplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select * from EmployeeDb where id = id and department = :department", nativeQuery = true)
    List<Employee> getEmployeeByDepartment(List<String> department);
}

