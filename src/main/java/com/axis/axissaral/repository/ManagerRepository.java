package com.axis.axissaral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.axissaral.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{

	public Manager findByUsername(String username);
}
