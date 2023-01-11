package com.axis.axissaral.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.axis.axissaral.entity.Project;
import com.axis.axissaral.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
	
	public void addProject(Project project) {
		
		Project project1 = new Project();
		project1.setProjectName(project.getProjectName());	
		project1.setStatus(project.getStatus());		
		project1.setDescription(project.getDescription());		

		
		projectRepository.save(project1);
		
	}
	
	public List<Project> showProject() {
		return projectRepository.findAll();
	}
	
	
	

}
