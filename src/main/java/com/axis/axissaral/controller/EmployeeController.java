package com.axis.axissaral.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.axissaral.dto.employee.AddEmployeeDto;
import com.axis.axissaral.entity.Employee;
import com.axis.axissaral.service.EmployeeService;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee/addemployee")
	public ResponseEntity<String> addEmployee(@RequestBody AddEmployeeDto empDto){
		
		employeeService.addEmployee(empDto);
		
		return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);

	}
	
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeService.allEmployees();
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeByEmpID(@PathVariable Integer id ){
        return employeeService.getEmployeeByEmpID(id);
    }
	
	
	

}
