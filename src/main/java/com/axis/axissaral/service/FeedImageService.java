package com.axis.axissaral.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.axissaral.entity.FeedImage;
import com.axis.axissaral.exception.FeedImageNotFoundException;
import com.axis.axissaral.exception.FeedImageStorageException;
import com.axis.axissaral.repository.FeedImageRepository;


@Service
public class FeedImageService {

	@Autowired
	private FeedImageRepository feedImageRepository;




	public FeedImage getFeedImageById(int feedId) {
		
		return feedImageRepository.findById(feedId).orElseThrow(() -> new FeedImageNotFoundException("Image not Exist for Feed ID: " + feedId));
	}

	public void addFeedImage(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new FeedImageStorageException("Filename contains Invalid Path Sequence" + fileName);
			}
			FeedImage feedImage = new FeedImage(fileName, file.getContentType(), file.getBytes());
			feedImageRepository.save(feedImage);
		} catch(IOException e) {
			throw new FeedImageStorageException("Could not store file " + fileName + ". Please try again!");
		}
		
	}
	
	
	
}
