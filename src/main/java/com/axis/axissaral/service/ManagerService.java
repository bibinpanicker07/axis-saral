package com.axis.axissaral.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.axis.axissaral.config.JwtRequestFilter;
import com.axis.axissaral.entity.CustomUserDetails;
import com.axis.axissaral.entity.Employee;
import com.axis.axissaral.entity.Manager;
import com.axis.axissaral.repository.ManagerRepository;
@Service
public class ManagerService {
	
	@Autowired
	ManagerRepository managerRepository;
	
	
	 public List<Manager> allManagers() {
	        return managerRepository.findAll();
	   }
	 
	 
	 public Manager getManagerByEmpID(int empID) {
		 return managerRepository.findById(empID).get();
	 }
	

}
