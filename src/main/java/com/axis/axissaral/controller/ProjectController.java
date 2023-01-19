package com.axis.axissaral.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.axis.axissaral.entity.Project;
import com.axis.axissaral.service.ProjectService;


@RestController

@CrossOrigin("http://localhost:3000")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addProject(@RequestBody Project project){
		
		projectService.addProject(project);
		
		return new ResponseEntity<String>("project created Successfully", HttpStatus.CREATED);

	}
	

	@GetMapping("/allprojects")
    public List<Project> getAllProjects(){

        return projectService.showProject();
    }
	@GetMapping("/project/{id}")
    public Project getProjectById(@PathVariable Integer id ){

        return projectService.showProjectById(id);
    }
}
