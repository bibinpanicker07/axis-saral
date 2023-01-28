package com.axis.axissaral.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.axissaral.entity.Dvp;

@Repository
public interface DvpRepository extends JpaRepository<Dvp, Integer>{
	
	public Dvp findByUsername(String username);
	

}
