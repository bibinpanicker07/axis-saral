package com.axis.axissaral.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.axis.axissaral.dto.employee.AddEmployeeDto;
import com.axis.axissaral.entity.CustomUserDetails;
import com.axis.axissaral.entity.Employee;
import com.axis.axissaral.entity.Manager;
import com.axis.axissaral.repository.EmployeeRepository;
import com.axis.axissaral.repository.ManagerRepository;
import com.axis.axissaral.repository.ModuleRepository;
import com.axis.axissaral.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service // EmployeeService is the JwtUserDetailsService..
public class EmployeeService implements UserDetailsService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;


	
	
	public void addEmployee(AddEmployeeDto empdto) {
		
		
		if(empdto.getDesignation().equalsIgnoreCase("manager")) {
			Manager emp = new Manager();
			emp.setFirstName(empdto.getFirstName());
			emp.setLastName(empdto.getLastName());
			emp.setUsername(empdto.getUsername());
			emp.setPassword(bcryptEncoder.encode(empdto.getPassword()));
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
			emp.setUsername(empdto.getUsername());
			emp.setPassword(bcryptEncoder.encode(empdto.getPassword()));
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
	 public List<Employee> allEmployees() {
	        return employeeRepository.findAll();
	   }
	 
	 public Employee getEmployeeByEmpID(int empID) {
		 return employeeRepository.findById(empID).get();
	 }
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		final Employee emp = this.employeeRepository.findByUsername(username);
		if(emp==null) {
			throw new UsernameNotFoundException("User not found !!");
		}else {
			return new CustomUserDetails(emp);
		}
		
	}
	 
	 

//	 

		
}
