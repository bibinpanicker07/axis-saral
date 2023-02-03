package com.axis.axissaral.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.axissaral.entity.Model;
import com.axis.axissaral.service.EmailService;



@RestController
@CrossOrigin("http://localhost:3000")
public class EmailController {
	
	@Autowired
	public EmailService emailservice;
	
	
	@PostMapping("/send")
	public String Email(@RequestBody Model model) {
		
		emailservice.sendSimpleEmail(model.getBody(), model.getSubject());
		return "Check your inbox..!";
	}
	
}
