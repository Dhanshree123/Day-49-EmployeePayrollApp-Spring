package com.employeePayrollApp.services;

import java.util.List;

import com.employeePayrollApp.dto.EmployeePayrollDTO;
import com.employeePayrollApp.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeePayrollData();
	EmployeePayrollData getEmployeePayrollDataById(int empId);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

	EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO);

	void deleteEmployeePayrollData(int empId);
}
