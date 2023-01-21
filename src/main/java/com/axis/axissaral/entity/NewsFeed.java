package com.axis.axissaral.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "news_feed")
public class NewsFeed {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Integer newsFeedId;
	 
	 
	 @Column(name = "description")
	 private @NotBlank String description;
	 
	 @Column(name = "image")
	 private String imageUrl;

	 @Column(name = "date")
	 private  Date date;
	 
	 @OneToMany(mappedBy = "newsFeed",fetch = FetchType.LAZY)
	 private Set<Comment> comments;


	
	public Integer getNewsFeedId() {
		return newsFeedId;
	}

	public void setNewsFeedId(Integer newsFeedId) {
		this.newsFeedId = newsFeedId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}



	public NewsFeed() {
		super();
	}

}
