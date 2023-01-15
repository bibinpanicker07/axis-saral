package com.axis.axissaral.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.axissaral.entity.FeedImage;


@Repository
public interface FeedImageRepository extends JpaRepository<FeedImage, Integer>{
	
}
