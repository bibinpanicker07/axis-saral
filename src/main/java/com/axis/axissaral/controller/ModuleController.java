package com.axis.axissaral.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.axissaral.dto.module.ModuleDto;
import com.axis.axissaral.entity.Module;
import com.axis.axissaral.service.ModuleService;

@RestController

@CrossOrigin("http://localhost:3000")
public class ModuleController {
	
	@Autowired
	ModuleService moduleService;
	
	@PostMapping("/modules/add")
	public ResponseEntity<String> addModule(@RequestBody ModuleDto moduleDto){
		
		moduleService.addModule(moduleDto);
		
		return new ResponseEntity<String>("Module created Successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/allmodules")
	public List<Module> allModules(){
		return moduleService.findModules();
	}

}
