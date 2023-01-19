package com.axis.axissaral.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.axissaral.dto.stakeHolder.StakeHolderDto;
import com.axis.axissaral.entity.StakeHolder;
import com.axis.axissaral.repository.ProjectRepository;
import com.axis.axissaral.repository.StakeHolderRepository;

@Service
public class StakeHolderService {
	
	@Autowired
	StakeHolderRepository stakeHolderRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	public void addStakeHolder(StakeHolderDto stakeHolderDto) {
		
		StakeHolder stakeHolder = new StakeHolder();
		stakeHolder.setFirstName(stakeHolderDto.getFirstName());
		stakeHolder.setLastName(stakeHolderDto.getLastName());
		stakeHolder.setEmail(stakeHolderDto.getEmail());
		stakeHolder.setGender(stakeHolderDto.getGender());
		stakeHolder.setStatus("ACTIVE");
		stakeHolder.setDesignation(stakeHolderDto.getDesignation());
		stakeHolder.setProject(projectRepository.findByprojectName(stakeHolderDto.getProjectName()));
		
		
		stakeHolderRepository.save(stakeHolder);
	}
	
	
	

}
