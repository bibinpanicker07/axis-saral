package com.axis.axissaral.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.axissaral.entity.ProfileImage;


@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImage, String> {
	

	ProfileImage findByemployeeId(String id);
	ProfileImage findBymanagerId(String id);

	ProfileImage findBystakeHolderId(String id);

}
