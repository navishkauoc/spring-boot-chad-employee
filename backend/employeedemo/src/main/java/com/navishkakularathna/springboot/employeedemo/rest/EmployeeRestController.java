package com.navishkakularathna.springboot.employeedemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	// Get a single employee
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Cannot find an Employee by the given ID: " + employeeId);
		}

		return employee;
	}

	// Adding a new Employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		theEmployee.setId(0);

		employeeService.save(theEmployee);

		return theEmployee;
	}

	// Update an employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {

		employeeService.save(theEmployee);

		return theEmployee;
	}

	// Delete an employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {

		Employee tempEmployee = employeeService.findById(employeeId);

		if (tempEmployee == null) {
			throw new RuntimeException("Cannot find an Employee by the given ID :" + employeeId);
		}

		employeeService.deleteById(employeeId);

		return "Deleted employee ID : " + employeeId;
	}

}
