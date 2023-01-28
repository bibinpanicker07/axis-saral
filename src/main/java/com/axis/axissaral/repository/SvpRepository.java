package com.axis.axissaral.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.axissaral.entity.Svp;

@Repository
public interface SvpRepository extends JpaRepository<Svp, Integer>{
	
	public Svp findByUsername(String username);
	

}
