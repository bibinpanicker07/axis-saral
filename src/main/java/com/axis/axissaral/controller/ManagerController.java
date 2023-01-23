package com.axis.axissaral.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.axis.axissaral.entity.Employee;
import com.axis.axissaral.entity.Manager;
import com.axis.axissaral.service.ManagerService;
@RestController
@CrossOrigin("http://localhost:3000")
public class ManagerController {
	
	@Autowired
	private ManagerService managerservice;

    @GetMapping("/manager")
    public List<Manager> getAllEmployees(){
        return managerservice.allManagers();
    }
    @GetMapping("/manager/{id}")
    public Manager getEmployeeByEmpID(@PathVariable Integer id ){
        return managerservice.getManagerByEmpID(id);
    }
}
