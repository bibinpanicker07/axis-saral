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

	
	public ProfileImage getEmployeeProfileImageById(String userId) {
		return profileImageRepository.findByemployeeId(userId);
	}
	public ProfileImage getManagerProfileImageById(String userId) {
		return profileImageRepository.findBymanagerId(userId);
	}
	public ProfileImage getDvpProfileImageById(String userId) {
		return profileImageRepository.findBydvpId(userId);
	}
	public ProfileImage getSvpProfileImageById(String userId) {
		return profileImageRepository.findBysvpId(userId);
	}

	public void addEmployeeProfileImage(String userId, MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new ProfileImageStorageException("Filename contains Invalid Path Sequence" + fileName);
			}
			ProfileImage profileImage = new ProfileImage();
			profileImage.setEmployeeId(userId);
			profileImage.setFileName(fileName);
			profileImage.setFileType(file.getContentType());
			profileImage.setData(file.getBytes());
			profileImageRepository.save(profileImage);
		} catch(IOException e) {
			throw new ProfileImageStorageException("Could not store file " + fileName + ". Please try again!");
		}
	}
	public void addManagerProfileImage(String userId, MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new ProfileImageStorageException("Filename contains Invalid Path Sequence" + fileName);
			}
			ProfileImage profileImage = new ProfileImage();
			profileImage.setManagerId(userId);
			profileImage.setFileName(fileName);
			profileImage.setFileType(file.getContentType());
			profileImage.setData(file.getBytes());
			profileImageRepository.save(profileImage);
		} catch(IOException e) {
			throw new ProfileImageStorageException("Could not store file " + fileName + ". Please try again!");
		}
	}
	public void addDvpProfileImage(String userId, MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new ProfileImageStorageException("Filename contains Invalid Path Sequence" + fileName);
			}
			ProfileImage profileImage = new ProfileImage();
			profileImage.setDvpId(userId);
			profileImage.setFileName(fileName);
			profileImage.setFileType(file.getContentType());
			profileImage.setData(file.getBytes());
			profileImageRepository.save(profileImage);
		} catch(IOException e) {
			throw new ProfileImageStorageException("Could not store file " + fileName + ". Please try again!");
		}
	}
	public void addSvpProfileImage(String userId, MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new ProfileImageStorageException("Filename contains Invalid Path Sequence" + fileName);
			}
			ProfileImage profileImage = new ProfileImage();
			profileImage.setSvpId(userId);
			profileImage.setFileName(fileName);
			profileImage.setFileType(file.getContentType());
			profileImage.setData(file.getBytes());
			profileImageRepository.save(profileImage);
		} catch(IOException e) {
			throw new ProfileImageStorageException("Could not store file " + fileName + ". Please try again!");
		}
	}
	
	
}
