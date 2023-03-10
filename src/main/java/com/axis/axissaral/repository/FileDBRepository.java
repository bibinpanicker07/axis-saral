package com.axis.axissaral.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.axissaral.entity.Employee;
import com.axis.axissaral.entity.FileDB;
import com.axis.axissaral.entity.Manager;


@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
	
	FileDB findByname(String name);
	FileDB findBynameAndEmployee(String name,Employee emp);
	FileDB findBynameAndManager(String name,Manager emp);
}
