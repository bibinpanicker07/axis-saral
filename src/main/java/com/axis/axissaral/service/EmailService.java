package com.axis.axissaral.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.axis.axissaral.entity.Employee;
import com.axis.axissaral.repository.EmployeeRepository;




@Service
public class EmailService {
	
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public void sendSimpleEmail(
                                String subject,
                                String body
    ) {
    	
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("vaidyabhagyesh@gmail.com");

        List<Employee> empList = employeeRepository.findAll();
        
        for(Employee i :empList) {
        message.setTo(i.getUsername());
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Sucess");
        }


    }
   
    

    
	
	
}