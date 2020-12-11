package com.employeePayrollApp.model;

import com.employeePayrollApp.dto.EmployeePayrollDTO;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeePayrollData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private int id;
	private String name;
	private long salary;
	private String profilePic;
	private String gender;
	private String[] department;
	private String note;
	private String startDate;
	
	public EmployeePayrollData() {
		
	}
	

	public EmployeePayrollData(int id, String name, long salary, String profilePic, String gender, String[] department, String note, String startDate) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.profilePic = profilePic;
		this.gender = gender;
		this.department = department;
		this.note = note;
		this.startDate = startDate;
	}

	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.name=empPayrollDTO.name;
		this.salary=empPayrollDTO.salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	public String getProfilePic() {
		return profilePic;
	}
	
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getDepartment() {
		return department;
	}
	public void setDepartment(String[] department) {
		this.department = department;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public String toString() {
		return "EmployeePayrollData [id=" + id + ", name=" + name + ", salary=" + salary + ", profilePic=" + profilePic
				+ ", gender=" + gender + ", department=" + Arrays.toString(department) + ", note=" + note
				+ ", startDate=" + startDate + "]";
	}
}