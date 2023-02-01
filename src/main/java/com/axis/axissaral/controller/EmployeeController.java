package com.axis.axissaral.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.axissaral.dto.employee.AddEmployeeDto;
import com.axis.axissaral.entity.Dvp;
import com.axis.axissaral.entity.Employee;
import com.axis.axissaral.entity.Manager;
import com.axis.axissaral.entity.Svp;
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
	
//    @GetMapping("/employee")
//    public List<Employee> getAllEmployees(){
//        return employeeService.allEmployees();
//    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeByEmpID(@PathVariable Integer id ){
        return employeeService.getEmployeeByEmpID(id);
    }
    @GetMapping("/Assistant Vice President/{id}")
    public Manager getavpByEmpID(@PathVariable Integer id ){
        return employeeService.getavpByEmpID(id);
    }
    @GetMapping("/Deputy Vice President/{id}")
    public Dvp getdvpByEmpID(@PathVariable Integer id ){
        return employeeService.getdvpById(id);
    }
    @GetMapping("/Senior Vice President/{id}")
    public Svp getsvpByEmpID(@PathVariable Integer id ){
        return employeeService.getsvpByEmpID(id);
    }
    
	@GetMapping("/employee/")
    public ResponseEntity<?> getCurrentEmployee(){
        return employeeService.getCurrentEmployee();
    }
	

	
	
	
	
	
	
	@PutMapping("update/employee/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id,@RequestBody AddEmployeeDto updatedEmp){
		
		employeeService.updateEmployee(id,updatedEmp);
		
		return new ResponseEntity<String>("Employee Updated Successfully", HttpStatus.CREATED);

	}
	
	
	@PutMapping("update/Assistant Vice President/{id}")
	public ResponseEntity<String> updateManager(@PathVariable Integer id,@RequestBody AddEmployeeDto updatedEmp){
		
		employeeService.updateManager(id,updatedEmp);
		
		return new ResponseEntity<String>("Employee Updated Successfully", HttpStatus.CREATED);

	}
	
	@PutMapping("update/Deputy Vice President/{id}")
	public ResponseEntity<String> updateDvp(@PathVariable Integer id,@RequestBody AddEmployeeDto updatedEmp){
		
		employeeService.updateDvp(id,updatedEmp);
		
		return new ResponseEntity<String>("Employee Updated Successfully", HttpStatus.CREATED);

	}
	
	@PutMapping("update/Senior Vice President/{id}")
	public ResponseEntity<String> updateSvp(@PathVariable Integer id,@RequestBody AddEmployeeDto updatedEmp){
		
		employeeService.updateSvp(id,updatedEmp);
		
		return new ResponseEntity<String>("Employee Updated Successfully", HttpStatus.CREATED);

	}
	
	
	
	
}
