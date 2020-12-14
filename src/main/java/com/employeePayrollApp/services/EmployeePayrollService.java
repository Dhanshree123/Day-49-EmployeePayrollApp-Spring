package com.employeePayrollApp.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeePayrollApp.dto.EmployeePayrollDTO;
import com.employeePayrollApp.exceptions.EmployeePayrollException;
import com.employeePayrollApp.model.EmployeePayrollData;


@Service
public class EmployeePayrollService implements IEmployeePayrollService{
	
	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
/*	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmailService emailService;
*/

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		
		return employeePayrollList.stream()
						   .filter(empData -> empData.getEmployeeId() == empId)
						   .findFirst()
						   .orElseThrow(() -> 
						   new EmployeePayrollException("Employee Not Found"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
	//	emailService.sendSimpleMessage("jayeshpatil1830@gmail.com","Email for confirmation","Registration done");
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(employeePayrollList.size()+1, empPayrollDTO);	
		employeePayrollList.add(empData);
		return empData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		employeePayrollList.set(empId-1, empData);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeePayrollList.remove(empId-1);
	}


}