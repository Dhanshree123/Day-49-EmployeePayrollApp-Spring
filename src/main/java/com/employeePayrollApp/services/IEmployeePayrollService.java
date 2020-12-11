package com.employeePayrollApp.services;

import java.util.List;

import com.employeePayrollApp.dto.EmployeePayrollDTO;
import com.employeePayrollApp.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeePayrollData();
	EmployeePayrollData getEmployeePayrollDataById(int empId);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollData empPayrollData);

	EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollData empPayrollData);

	void deleteEmployeePayrollData(int empId);
}
