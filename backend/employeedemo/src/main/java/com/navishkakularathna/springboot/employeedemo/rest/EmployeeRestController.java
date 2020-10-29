package com.navishkakularathna.springboot.employeedemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navishkakularathna.springboot.employeedemo.dao.EmployeeDAO;
import com.navishkakularathna.springboot.employeedemo.entity.Employee;
import com.navishkakularathna.springboot.employeedemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	//Inject EmployeeDAO (constructor injection)
	@Autowired
	public EmployeeRestController(EmployeeService theEmplyeeService) {
		employeeService = theEmplyeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

}
