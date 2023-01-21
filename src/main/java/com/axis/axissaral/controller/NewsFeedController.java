package com.axis.axissaral.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.axissaral.entity.NewsFeed;
import com.axis.axissaral.service.NewsFeedService;

@RestController
@CrossOrigin("http://localhost:3000")
public class NewsFeedController {
	
	@Autowired
	private NewsFeedService newsFeedService;
	
	@PostMapping("/news/add")
	public ResponseEntity<String> addFeed(@RequestBody NewsFeed newsFeed){
		newsFeedService.addFeed(newsFeed);
		return new ResponseEntity<String>("News Added Successfully", HttpStatus.CREATED);

	}

	@GetMapping("/news")
    public List<NewsFeed> getAllFeeds(){

        return newsFeedService.getAllFeeds();
    }

}
