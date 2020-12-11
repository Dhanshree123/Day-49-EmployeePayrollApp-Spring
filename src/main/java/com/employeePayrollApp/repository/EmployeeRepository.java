package com.employeePayrollApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeePayrollApp.model.EmployeePayrollData;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeePayrollData,Integer> {

}