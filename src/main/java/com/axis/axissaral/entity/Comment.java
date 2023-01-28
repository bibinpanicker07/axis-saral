package com.axis.axissaral.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "comment")
public class Comment {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Integer commentId;

	 @Column(name = "message")
	 private @NotBlank String message;
	 
	 @ManyToOne()
	 @JoinColumn(name = "employee_id", referencedColumnName = "id")
	 private Employee employee;
	 
	 @ManyToOne()
	 @JoinColumn(name = "manager_id", referencedColumnName = "id")
	 private Manager manager;
	 
	 @ManyToOne()
	 @JoinColumn(name = "dvp_id", referencedColumnName = "id")
	 private Dvp dvp;
	 
	 @ManyToOne()
	 @JoinColumn(name = "svp_id", referencedColumnName = "id")
	 private Svp svp;

	 @JsonIgnore
	 @ManyToOne()
	 @JoinColumn(name = "news_feed_id", referencedColumnName = "id")
	 private NewsFeed newsFeed;

	 
	 
	public Dvp getDvp() {
		return dvp;
	}

	public void setDvp(Dvp dvp) {
		this.dvp = dvp;
	}

	public Svp getSvp() {
		return svp;
	}

	public void setSvp(Svp svp) {
		this.svp = svp;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public NewsFeed getNewsFeed() {
		return newsFeed;
	}

	public void setNewsFeed(NewsFeed newsFeed) {
		this.newsFeed = newsFeed;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

}
