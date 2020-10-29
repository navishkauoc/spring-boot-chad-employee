package com.navishkakularathna.springboot.employeedemo.dao;

import java.util.List;

import com.navishkakularathna.springboot.employeedemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int id);

}
