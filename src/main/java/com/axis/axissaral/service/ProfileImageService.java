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

	
	public ProfileImage getProfileImageByusername(String userName) {
		return profileImageRepository.findByuserName(userName);
	}


	public void addEmployeeProfileImage(String userName, MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new ProfileImageStorageException("Filename contains Invalid Path Sequence" + fileName);
			}
			ProfileImage profileImage = new ProfileImage();
			profileImage.setUserName(userName);
			profileImage.setFileName(fileName);
			profileImage.setFileType(file.getContentType());
			profileImage.setData(file.getBytes());
			profileImageRepository.save(profileImage);
		} catch(IOException e) {
			throw new ProfileImageStorageException("Could not store file " + fileName + ". Please try again!");
		}
	}
	
	
	
}
