package com.employeePayrollApp.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeePayrollApp.dto.EmployeePayrollDTO;
import com.employeePayrollApp.exceptions.EmployeePayrollException;
import com.employeePayrollApp.model.EmployeePayrollData;
import com.employeePayrollApp.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{
	
	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	
	@Autowired
	private EmployeeRepository employeeRepository;
/*	
	@Autowired
	private EmailService emailService;
*/

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		
		return employeeRepository
				.findById(empId)
				.orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		//emailService.sendSimpleMessage("jayeshpatil1830@gmail.com","Email for confirmation","Registration done");
		EmployeePayrollData empData = new EmployeePayrollData(empPayrollDTO);	
		log.debug("Emp Data:"+empData.toString());
		return employeeRepository.save(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		empData.updateEmployeePayrollDTO(empPayrollDTO);
		return employeeRepository.save(empData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		employeeRepository.delete(empData);
	}
	
	@Override
	public List<EmployeePayrollData> getEmployeeByDepartment(String department) {
		return employeeRepository.findEmployeesByDepartment(department);
	}


}