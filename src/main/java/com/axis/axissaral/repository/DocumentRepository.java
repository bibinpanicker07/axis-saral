package com.axis.axissaral.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.axis.axissaral.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {
	
}
