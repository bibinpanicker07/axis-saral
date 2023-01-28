package com.axis.axissaral.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.axissaral.entity.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	
	Department findBydepartmentName(String deptName);
}
