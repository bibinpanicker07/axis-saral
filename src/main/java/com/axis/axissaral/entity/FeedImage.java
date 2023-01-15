package com.axis.axissaral.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
@Entity
public class FeedImage {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Integer FeedImageId;
	
	private String fileName;
	private String fileType;
	
	@Lob
	private byte[] feedImage;

	public FeedImage() {
	}

	public FeedImage(String fileName, String fileType, byte[] feedImage) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.feedImage = feedImage;
	}



	public Integer getFeedImageId() {
		return FeedImageId;
	}

	public void setFeedImageId(Integer feedImageId) {
		FeedImageId = feedImageId;
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

	public byte[] getFeedImage() {
		return feedImage;
	}

	public void setFeedImage(byte[] feedImage) {
		this.feedImage = feedImage;
	}

	
	
	
}
