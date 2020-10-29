package com.navishkakularathna.springboot.employeedemo.service;

import java.util.List;

import com.navishkakularathna.springboot.employeedemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int id);

}
