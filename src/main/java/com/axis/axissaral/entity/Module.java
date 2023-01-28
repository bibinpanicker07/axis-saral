package com.axis.axissaral.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "modules")
public class Module {
	

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Integer moduleId;

	 @Column(name = "module_name")
	 private @NotBlank String moduleName;


	 @Column(name = "module_description")
	 private @NotBlank String moduleDescription;

	 
	 @JsonIgnore
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "project_id", nullable = false)
	 Project project;

	 

	 @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "module")
	 @JoinColumn(name = "manager_id")
	 private  Manager manager;
	 

	 
	 @OneToMany(mappedBy = "module",fetch = FetchType.LAZY)
	 private Set<Employee> employees;
	 
	 
	 public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	

	public String getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Module() {
		
		// TODO Auto-generated constructor stub
	}

	public Module(@NotBlank String moduleName, Project project, Manager manager, Set<Employee> employees) {
		super();
		this.moduleName = moduleName;
		this.project = project;
		this.manager = manager;
		this.employees = employees;
	}

	
	 
}
