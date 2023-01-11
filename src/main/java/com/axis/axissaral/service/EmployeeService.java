package com.axis.axissaral.service;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.axissaral.dto.employee.AddEmployeeDto;
import com.axis.axissaral.entity.Employee;
import com.axis.axissaral.entity.Manager;
import com.axis.axissaral.repository.EmployeeRepository;
import com.axis.axissaral.repository.ManagerRepository;
import com.axis.axissaral.repository.ModuleRepository;
import com.axis.axissaral.repository.ProjectRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	ModuleRepository moduleRepository;
	
	
	
	public void addEmployee(AddEmployeeDto empdto) {
		
		
		if(empdto.getDesignation().equalsIgnoreCase("manager")) {
			Manager emp = new Manager();
			emp.setFirstName(empdto.getFirstName());
			emp.setLastName(empdto.getLastName());
			emp.setEmail(empdto.getEmail());
			emp.setPassword(empdto.getPassword());
			emp.setGender(empdto.getGender());
			emp.setStatus("Active");
			emp.setDateOfJoining(LocalDate.now());
			emp.setMobileNumber(empdto.getMobileNumber());
			emp.setDesignation("Manager");
			emp.setProjectName(empdto.getProjectName());
			emp.setModule(moduleRepository.findBymoduleName(empdto.getModuleName()));
			
			managerRepository.save(emp);
		}else {
			Employee emp = new Employee();
			emp.setFirstName(empdto.getFirstName());
			emp.setLastName(empdto.getLastName());
			emp.setEmail(empdto.getEmail());
			emp.setPassword(empdto.getPassword());
			emp.setGender(empdto.getGender());
			emp.setStatus("Active");
			emp.setDateOfJoining(LocalDate.now());
			emp.setMobileNumber(empdto.getMobileNumber());
			emp.setDesignation(empdto.getDesignation());
			emp.setProjectName(empdto.getProjectName());
			emp.setModule(moduleRepository.findBymoduleName(empdto.getModuleName()));
			
			employeeRepository.save(emp);
		}
		
		
	}

}
