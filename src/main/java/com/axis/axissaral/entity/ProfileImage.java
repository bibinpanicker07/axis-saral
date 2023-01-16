package com.axis.axissaral.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class ProfileImage {

	@Id
	private String fileName;
	private String fileType;
	private Integer employeeId;
	private Integer managerId;
	private Integer stakeHolderId;

	@Lob
	private byte[] data;

	public ProfileImage() {
		
	}


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getStakeHolderId() {
		return stakeHolderId;
	}

	public void setStakeHolderId(Integer stakeHolderId) {
		this.stakeHolderId = stakeHolderId;
	}
	
	
}
