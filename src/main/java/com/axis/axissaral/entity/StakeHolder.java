package com.axis.axissaral.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;



@Entity
@Table(name = "stakeholders")
public class StakeHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer stakeHolderId;

    @Column(name = "first_name")
    private @NotBlank String firstName;

    @Column(name = "last_name")
    private @NotBlank String lastName;

    @Column(name = "email")
    private @NotBlank String email;
    
    @Column(name = "gender")
    private  String gender;
    
    @Column(name = "status")
    private  String status;
 

    @Column(name = "designation")
    private @NotBlank String designation;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    Project project;


	public Integer getStakeHolderId() {
		return stakeHolderId;
	}

	public void setStakeHolderId(Integer stakeHolderId) {
		this.stakeHolderId = stakeHolderId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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




	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


	
	
	

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public StakeHolder() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}