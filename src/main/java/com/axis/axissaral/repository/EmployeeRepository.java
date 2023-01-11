package com.axis.axissaral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.axissaral.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
