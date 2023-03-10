package com.axis.axissaral.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "managers")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer managerId;

    @Column(name = "first_name")
    private @NotBlank String firstName;

    @Column(name = "last_name")
    private @NotBlank String lastName;

    @Column(name = "email")
    private @NotBlank String username;
    
    @Column(name = "password")
    private @NotBlank String password;
    
    @Column(name = "gender")
    private @NotBlank String gender;
    
    @Column(name = "status")
    private @NotBlank String status;
    
    @Column(name = "doj")
    private  LocalDate dateOfJoining;
    
    @Column(name = "mobile_number")
    private  Long mobileNumber;
    
    @Column(name = "designation")
    private @NotBlank String designation;
    
    @Column(name = "project_name")
    private @NotBlank String projectName;
    
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "module_id")
    private Module module;
    
    @JsonIgnore
	@OneToMany(mappedBy = "manager",fetch = FetchType.LAZY)
	private Set<Comment> comments;
    
    @JsonIgnore
	@OneToMany(mappedBy = "manager",fetch = FetchType.LAZY)
	private Set<FileDB> files;

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Set<FileDB> getFiles() {
		return files;
	}

	public void setFiles(Set<FileDB> files) {
		this.files = files;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}