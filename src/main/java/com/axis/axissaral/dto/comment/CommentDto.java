package com.axis.axissaral.dto.comment;

import javax.validation.constraints.NotBlank;

public class CommentDto {
	
	 private @NotBlank String message;
	 private Integer empId;
	 private Integer feedId;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getFeedId() {
		return feedId;
	}
	public void setFeedId(Integer feedId) {
		this.feedId = feedId;
	}

}
