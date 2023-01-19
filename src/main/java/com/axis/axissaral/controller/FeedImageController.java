package com.axis.axissaral.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.axis.axissaral.entity.FeedImage;
import com.axis.axissaral.service.FeedImageService;



@RestController
@CrossOrigin("http://localhost:3000")
public class FeedImageController {

	@Autowired
	private FeedImageService feedImageService;

	@GetMapping("/feed-image/{feedId}")
	public ResponseEntity<Resource> getProfileImageById(@PathVariable int feedId) {
		FeedImage feedImage = feedImageService.getFeedImageById(feedId);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(feedImage.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + feedImage.getFileName() + "\"")
				.body(new ByteArrayResource(feedImage.getFeedImage()));
	}

//	@GetMapping("/feed-image/{feedId}")
//	public ResponseEntity<byte[]> getFeedImageById(@PathVariable int feedId) {
//		FeedImage feedImage = feedImageService.getFeedImageById(feedId);
//		return new ResponseEntity<>(Base64.getEncoder().encode(feedImage.getFeedImage()), HttpStatus.OK);
//	}

	@PostMapping("/feed-image/add")
	public ResponseEntity<String> addFeedImage(@RequestParam("file") MultipartFile file) {
		feedImageService.addFeedImage(file);
		return new ResponseEntity<>("Feed Image Uploaded Successfully", HttpStatus.OK);
	}
}
