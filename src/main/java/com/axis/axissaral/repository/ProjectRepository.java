package com.axis.axissaral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.axissaral.entity.Project;


public interface ProjectRepository extends JpaRepository<Project, Integer>{

	Project findByprojectName(String projectName);
}
