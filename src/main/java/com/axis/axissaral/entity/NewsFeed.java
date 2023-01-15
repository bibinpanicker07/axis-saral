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

	 @Column(name = "title")
	 private @NotBlank String title;
	 
	 @Column(name = "description")
	 private @NotBlank String description;
	 
	 @Column(name = "date")
	 private  Date date;
	 
	 @OneToMany(mappedBy = "newsFeed",fetch = FetchType.LAZY)
	 private Set<Comment> comments;

	public Integer getNewFeedId() {
		return newsFeedId;
	}

	public void setNewFeedId(Integer newFeedId) {
		this.newsFeedId = newFeedId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public NewsFeed(@NotBlank String title, @NotBlank String description, @NotBlank Date date, Set<Comment> comments) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		this.comments = comments;
	}

	public NewsFeed(Integer newFeedId, @NotBlank String title, @NotBlank String description, Date date) {
		super();
		this.newsFeedId = newFeedId;
		this.title = title;
		this.description = description;
		this.date = date;
	}

	public NewsFeed(Integer newsFeedId, @NotBlank String title, @NotBlank String description, Date date,
			Set<Comment> comments) {
		super();
		this.newsFeedId = newsFeedId;
		this.title = title;
		this.description = description;
		this.date = date;
		this.comments = comments;
	}

	public NewsFeed() {
		super();
	}

}
