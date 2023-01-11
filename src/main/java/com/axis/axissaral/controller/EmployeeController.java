package com.axis.axissaral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.axissaral.dto.employee.AddEmployeeDto;
import com.axis.axissaral.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add-employee")
	public ResponseEntity<String> addEmployee(@RequestBody AddEmployeeDto empDto){
		
		employeeService.addEmployee(empDto);
		
		return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);

	}
	

}
