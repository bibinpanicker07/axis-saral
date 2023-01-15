package com.axis.axissaral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.axissaral.dto.stakeHolder.StakeHolderDto;
import com.axis.axissaral.service.StakeHolderService;

@RestController
@RequestMapping("/stakeHolder")
@CrossOrigin("http://localhost:3000")
public class StakeHolderController {
	
	
	@Autowired
	private StakeHolderService stakeHolderService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addProject(@RequestBody StakeHolderDto stakeHolderDto){
		
		stakeHolderService.addStakeHolder(stakeHolderDto);
		
		return new ResponseEntity<String>("StakeHolder added Successfully", HttpStatus.CREATED);

	}


}
