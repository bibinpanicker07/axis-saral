package com.axis.axissaral.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.axissaral.entity.NewsFeed;
import com.axis.axissaral.repository.NewsFeedRepository;


@Service
public class NewsFeedService {
	
	@Autowired
	private NewsFeedRepository newsFeedRepository;
	
	public void addFeed(NewsFeed feed) {
		Date date = new Date();
		
		feed.setDate(date);
		newsFeedRepository.save(feed);
	}
	public List<NewsFeed> getAllFeeds() {
		return newsFeedRepository.findAllByOrderByDateDesc();
	}

}
