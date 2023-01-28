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

import com.axis.axissaral.entity.ProfileImage;
import com.axis.axissaral.service.ProfileImageService;


@RestController
@CrossOrigin("http://localhost:3000")
public class ProfileImageController {

	@Autowired
	private ProfileImageService profileImageService;


	  @GetMapping("/employee/profile-image/{userId}")
	  public ResponseEntity<Resource> getEmployeeProfileImageById(@PathVariable String userId) {
		  ProfileImage profileImage = profileImageService.getEmployeeProfileImageById(userId); return ResponseEntity.ok()
				  .contentType(MediaType.parseMediaType(profileImage.getFileType()))
				  .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
	  profileImage.getFileName() + "\"") .body(new ByteArrayResource(profileImage.getData())); 
	  }
	  
	  
	  @GetMapping("/Assistant Vice President/profile-image/{userId}") public ResponseEntity<Resource>
	  getManagerProfileImageById(@PathVariable String userId) {
		  ProfileImage profileImage = profileImageService.getManagerProfileImageById(userId); return ResponseEntity.ok()
				  .contentType(MediaType.parseMediaType(profileImage.getFileType()))
	  .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
	  profileImage.getFileName() + "\"") .body(new ByteArrayResource(profileImage.getData())); 
	  }
	  
	  
	  @GetMapping("/Deputy Vice President/profile-image/{userId}") public ResponseEntity<Resource>
	  getDvpImageById(@PathVariable String userId) {
		  ProfileImage profileImage = profileImageService.getDvpProfileImageById(userId); return ResponseEntity.ok()
	  .contentType(MediaType.parseMediaType(profileImage.getFileType()))
	  .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
	  profileImage.getFileName() + "\"") .body(new ByteArrayResource(profileImage.getData())); }
	 
	  
	  @GetMapping("/Senior Vice President/profile-image/{userId}") public ResponseEntity<Resource>
	  getSvpImageById(@PathVariable String userId) {
		  ProfileImage profileImage = profileImageService.getSvpProfileImageById(userId); return ResponseEntity.ok()
	  .contentType(MediaType.parseMediaType(profileImage.getFileType()))
	  .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
	  profileImage.getFileName() + "\"") .body(new ByteArrayResource(profileImage.getData())); }
	 
	  
//	@GetMapping("/profile-image/{userId}")
//	public ResponseEntity<byte[]> getProfileImageById(@PathVariable String userId) {
//		ProfileImage profileImage = profileImageService.getProfileImageById(userId);
//		return new ResponseEntity<>(Base64.getEncoder().encode(profileImage.getData()), HttpStatus.OK);
//	}

	@PostMapping("/employee/profile-image/add")
	public ResponseEntity<String> addEmployeeProfileImage(@RequestParam("userId") String userId,
			@RequestParam("file") MultipartFile file) {
		profileImageService.addEmployeeProfileImage(userId, file);
		return new ResponseEntity<>("Profile Image Uploaded Successfully", HttpStatus.OK);
	}
	@PostMapping("/Assistant Vice President/profile-image/add")
	public ResponseEntity<String> addManagerProfileImage(@RequestParam("userId") String userId,
			@RequestParam("file") MultipartFile file) {
		profileImageService.addManagerProfileImage(userId, file);
		return new ResponseEntity<>("Profile Image Uploaded Successfully", HttpStatus.OK);
	}
	@PostMapping("/Deputy Vice President/profile-image/add")
	public ResponseEntity<String> addDvpImage(@RequestParam("userId") String userId,
			@RequestParam("file") MultipartFile file) {
		profileImageService.addDvpProfileImage(userId, file);
		return new ResponseEntity<>("Profile Image Uploaded Successfully", HttpStatus.OK);
	}
	@PostMapping("/Senior Vice President/profile-image/add")
	public ResponseEntity<String> addSvpImage(@RequestParam("userId") String userId,
			@RequestParam("file") MultipartFile file) {
		profileImageService.addSvpProfileImage(userId, file);
		return new ResponseEntity<>("Profile Image Uploaded Successfully", HttpStatus.OK);
	}
}
