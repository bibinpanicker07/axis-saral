package com.axis.axissaral.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.axissaral.dto.department.DepartmentDto;
import com.axis.axissaral.entity.Department;
import com.axis.axissaral.repository.DepartmentRepository;
import com.axis.axissaral.repository.SvpRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private SvpRepository svpRepository;
	
	public void addDept(DepartmentDto department) {
		Department dept = new Department();
		dept.setDepartmentName(department.getDepartmentName());
		dept.setSvp(svpRepository.findByUsername(department.getSvpUsername()));
		departmentRepository.save(dept);
		
	}
	
	public List<Department> allDept() {
		return departmentRepository.findAll();
	}
	 public Department deptById(int id) {
		 return departmentRepository.findById(id).get();
	 }
	 
	 public void updateDept(int id,Department updatedDepartment) {
		 Department dept = departmentRepository.getById(id);
		 dept.setDepartmentName(updatedDepartment.getDepartmentName());
		 dept.setSvp(updatedDepartment.getSvp());
		 departmentRepository.save(dept);
		  
	 }
	 
	 
	 public void deleteDept(int id) {
		  departmentRepository.deleteById(id);
	 }
	

}
