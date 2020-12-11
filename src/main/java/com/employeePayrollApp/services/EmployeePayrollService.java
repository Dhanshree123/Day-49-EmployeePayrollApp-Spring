package com.employeePayrollApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeePayrollApp.dto.EmployeePayrollDTO;
import com.employeePayrollApp.model.EmployeePayrollData;
import com.employeePayrollApp.repository.EmployeeRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
	
	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmailService emailService;

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeeRepository.findById(empId).get();
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollData empPayrollData) {
		emailService.sendSimpleMessage("jayeshpatil1830@gmail.com","Email for confirmation","Registration done");
		return employeeRepository.save(empPayrollData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollData empPayrollData) {
		empPayrollData.setId(empId);
		return employeeRepository.save(empPayrollData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeeRepository.deleteById(empId);
	}


}