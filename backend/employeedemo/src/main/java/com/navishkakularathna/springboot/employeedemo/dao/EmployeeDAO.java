package com.navishkakularathna.springboot.employeedemo.dao;

import java.util.List;

import com.navishkakularathna.springboot.employeedemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();

}
