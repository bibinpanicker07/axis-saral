package com.axis.axissaral.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.axis.axissaral.entity.FileDB;




@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
	
	FileDB findByname(String name);

	
	@Query("select f from FileDB f where name=?1 and userName=?2")
	FileDB findBynameAnduserName(String name,String userName);
	
	
	
	
	
//	@Transactional
//	@Modifying
//	@Query("select FROM files WHERE ")
//	FileDB find();
//	
//	
	
	
}
