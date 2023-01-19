package com.axis.axissaral.dto.stakeHolder;



public class StakeHolderDto {
	
	private  String firstName;
    private  String lastName;
    private  String gender;
    private  String email;
    private  String designation;
    private String projectName;
    
	public StakeHolderDto(String firstName, String lastName, String email, String gender,
			 String designation, String projectName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.designation = designation;
		this.projectName = projectName;
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
    
    
    
    

}
