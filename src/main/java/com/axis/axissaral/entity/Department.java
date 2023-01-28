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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "department")
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","FieldHandler"})
public class Department {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Integer departmentId;

	 private @NotBlank String departmentName;
	 
	 
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Set<Employee> employees;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Set<Manager> managers;
	
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "dvp_id")
//    private Dvp dvp;

    @OneToOne(mappedBy = "department")
    private Dvp dvp;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "svp_id", nullable = false)
    private Svp svp;
    
    
    
    
    
	public Dvp getDvp() {
		return dvp;
	}

	public void setDvp(Dvp dvp) {
		this.dvp = dvp;
	}

	public Svp getSvp() {
		return svp;
	}

	public void setSvp(Svp svp) {
		this.svp = svp;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Manager> getManagers() {
		return managers;
	}

	public void setManagers(Set<Manager> managers) {
		this.managers = managers;
	}




	public Department(@NotBlank String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	
}
