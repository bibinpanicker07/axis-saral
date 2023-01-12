package com.axis.axissaral.dto.employee;

public class AddEmployeeDto {

    private  String firstName;
    private  String lastName;
    private  String username;
    private  String password;
    private  String gender;
    private  String status;
    private  Long mobileNumber;
    private  String designation;    
    private String projectName;
    private String moduleName;
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
	
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public AddEmployeeDto(String firstName, String lastName, String username, String password, String gender,
			String status, Long mobileNumber, String designation, String projectName, String moduleName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.status = status;
		this.mobileNumber = mobileNumber;
		this.designation = designation;
		this.projectName = projectName;
		this.moduleName = moduleName;
	}
	public AddEmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
     

}
