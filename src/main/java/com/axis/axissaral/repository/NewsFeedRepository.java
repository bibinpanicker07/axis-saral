package com.axis.axissaral.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.axissaral.entity.NewsFeed;


public interface NewsFeedRepository extends JpaRepository<NewsFeed, Integer> {


	List<NewsFeed> findAllByOrderByDateDesc();
}
