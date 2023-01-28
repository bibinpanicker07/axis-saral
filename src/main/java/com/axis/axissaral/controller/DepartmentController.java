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
import org.springframework.web.bind.annotation.RestController;

import com.axis.axissaral.dto.department.DepartmentDto;
import com.axis.axissaral.entity.Department;
import com.axis.axissaral.service.DepartmentService;

@RestController
@CrossOrigin("http://localhost:3000")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	
	
	@PostMapping("/department/add")
	public ResponseEntity<String> addDept(@RequestBody DepartmentDto dept){
		
		departmentService.addDept(dept);
		
		return new ResponseEntity<String>("Department Added Successfully", HttpStatus.CREATED);

	}

    @GetMapping("/department/")
    public List<Department> getAlldepts(){
        return departmentService.allDept();
    }


    @GetMapping("/department/{id}")
    public Department getdeptById(@PathVariable Integer id ){
        return departmentService.deptById(id);
    }
    
    @PutMapping("/department/update/{id}")
	public ResponseEntity<String> updateDept(@PathVariable Integer id ,@RequestBody Department dept){
		
		departmentService.updateDept(id,dept);
		
		return new ResponseEntity<String>("Department Updated Successfully", HttpStatus.CREATED);

	}
    
}
