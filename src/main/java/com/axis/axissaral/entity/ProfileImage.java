package com.axis.axissaral.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class ProfileImage {

	@Id
	private String fileName;
	private String fileType;
	private String employeeId;
	private String managerId;
	private String dvpId;
	private String svpId;

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

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}


	public String getDvpId() {
		return dvpId;
	}


	public void setDvpId(String dvpId) {
		this.dvpId = dvpId;
	}


	public String getSvpId() {
		return svpId;
	}


	public void setSvpId(String svpId) {
		this.svpId = svpId;
	}

	
	
	
}
