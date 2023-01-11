package com.axis.axissaral.dto.stakeHolder;



public class StakeHolderDto {
	
	private  String firstName;
    private  String lastName;
    private  String gender;
    private  String email;
    private  Long mobileNumber;
    private  String designation;
    private  Double salary;
    private String projectName;
    
	public StakeHolderDto(String firstName, String lastName, String email, String gender,
			Long mobileNumber, String designation, Double salary, String projectName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.designation = designation;
		this.salary = salary;
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
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
    
    
    
    

}
