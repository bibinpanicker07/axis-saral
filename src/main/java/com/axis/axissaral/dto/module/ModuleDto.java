package com.axis.axissaral.dto.module;

public class ModuleDto {
	
	private String moduleName;
	private String projectName;
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public ModuleDto(String moduleName, String projectName) {
		super();
		this.moduleName = moduleName;
		this.projectName = projectName;
	}
	
	

}
