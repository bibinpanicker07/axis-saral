package com.axis.axissaral.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

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
@CrossOrigin(value = "http://localhost:3000")
public class ProfileImageController {

	@Autowired
	private ProfileImageService profileImageService;

	/*
	 * SENDING RESOURCE TYPE
	 * 
	 * @GetMapping("/profile-image/{userId}") public ResponseEntity<Resource>
	 * getProfileImageById(@PathVariable String userId) { ProfileImage profileImage
	 * = profileImageService.getProfileImageById(userId); return ResponseEntity.ok()
	 * .contentType(MediaType.parseMediaType(profileImage.getFileType()))
	 * .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
	 * profileImage.getFileName() + "\"") .body(new
	 * ByteArrayResource(profileImage.getData())); }
	 */

	@GetMapping("/profile-image/{userId}")
	public ResponseEntity<byte[]> getProfileImageById(@PathVariable String userId) {
		ProfileImage profileImage = profileImageService.getProfileImageById(userId);
		return new ResponseEntity<>(Base64.getEncoder().encode(profileImage.getData()), HttpStatus.OK);
	}

	@PostMapping("/profile-image/add")
	public ResponseEntity<String> addProfileImage(@RequestParam("userId") String userId,
			@RequestParam("file") MultipartFile file) {
		profileImageService.addProfileImage(userId, file);
		return new ResponseEntity<>("Profile Image Uploaded Successfully", HttpStatus.OK);
	}
}
