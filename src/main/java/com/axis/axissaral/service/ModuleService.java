package com.axis.axissaral.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.axissaral.dto.module.ModuleDto;
import com.axis.axissaral.repository.ModuleRepository;
import com.axis.axissaral.repository.ProjectRepository;
import com.axis.axissaral.entity.Module;
@Service
public class ModuleService {
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired ProjectRepository projectRepository;
	
	public void addModule(ModuleDto moduleDto) {
		Module module1 = new Module();
		module1.setModuleName(moduleDto.getModuleName());
		module1.setProject(projectRepository.findByprojectName(moduleDto.getProjectName()));
		module1.setModuleDescription(moduleDto.getDescription());
		moduleRepository.save(module1);
	}
	
	public List<Module> findModules(){
		return (List<Module>) moduleRepository.findAll();
	}
	

}
