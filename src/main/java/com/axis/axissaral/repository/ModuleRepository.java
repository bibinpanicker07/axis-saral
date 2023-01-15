package com.axis.axissaral.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.axis.axissaral.entity.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer>{

	Module findBymoduleName(String moduleName);
}
