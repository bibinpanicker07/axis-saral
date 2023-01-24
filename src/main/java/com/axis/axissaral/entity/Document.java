package com.axis.axissaral.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Document {

	@Id
	private String documentId;
	private String fileName;
	private String fileType;
	
	@Lob
	private byte[] fileData;

	public Document() {
		
	}

	public Document(String documentId, String fileName, String fileType, byte[] fileData) {
		this.documentId = documentId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileData = fileData;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
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

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	
}
