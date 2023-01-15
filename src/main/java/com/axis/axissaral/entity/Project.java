package com.axis.axissaral.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "project")
public class Project {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Integer projectId;

	 @Column(name = "project_name")
	 private @NotBlank String projectName;
	 
	 @Column(name = "status")
	 private @NotBlank String status;
	 
	 @Column(name = "description")
	 private @NotBlank String description;
	 
	 //flow chart needed
	 

	 
	 @OneToMany(mappedBy = "project",fetch = FetchType.LAZY,
				cascade = CascadeType.ALL)
	 private Set<Module> modules;

	 
	 @OneToMany(mappedBy = "project", fetch = FetchType.LAZY,
				cascade = CascadeType.ALL)
	 private Set<StakeHolder> stakeHolders;

	 

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	public Set<StakeHolder> getStakeHolders() {
		return stakeHolders;
	}

	public void setStakeHolders(Set<StakeHolder> stakeHolders) {
		this.stakeHolders = stakeHolders;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	 
	 
}