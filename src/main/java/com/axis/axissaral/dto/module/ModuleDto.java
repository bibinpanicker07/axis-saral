package com.axis.axissaral.dto.module;

public class ModuleDto {
	
	private String moduleName;
	private String projectName;
	private String description;
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ModuleDto(String moduleName, String projectName, String description) {
		super();
		this.moduleName = moduleName;
		this.projectName = projectName;
		this.description = description;
	}

	

}
