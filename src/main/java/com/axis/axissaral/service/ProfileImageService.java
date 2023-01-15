package com.axis.axissaral.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.axissaral.entity.ProfileImage;
import com.axis.axissaral.exception.ProfileImageNotFoundException;
import com.axis.axissaral.exception.ProfileImageStorageException;
import com.axis.axissaral.repository.ProfileImageRepository;



@Service
public class ProfileImageService  {

	@Autowired
	private ProfileImageRepository profileImageRepository;

	
	public ProfileImage getProfileImageById(String userId) {
		return profileImageRepository.findById(userId).orElseThrow(() -> new ProfileImageNotFoundException("Image not Exist for User ID: " + userId));
	}

	public void addProfileImage(String userId, MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new ProfileImageStorageException("Filename contains Invalid Path Sequence" + fileName);
			}
			ProfileImage profileImage = new ProfileImage(userId, fileName, file.getContentType(), file.getBytes());
			profileImageRepository.save(profileImage);
		} catch(IOException e) {
			throw new ProfileImageStorageException("Could not store file " + fileName + ". Please try again!");
		}
	}
	
	
	
}
