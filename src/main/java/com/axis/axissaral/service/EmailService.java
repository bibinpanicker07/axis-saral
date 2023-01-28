package com.axis.axissaral.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.axis.axissaral.entity.Dvp;
import com.axis.axissaral.entity.Employee;
import com.axis.axissaral.entity.Manager;
import com.axis.axissaral.entity.Svp;
import com.axis.axissaral.repository.DvpRepository;
import com.axis.axissaral.repository.EmployeeRepository;
import com.axis.axissaral.repository.ManagerRepository;
import com.axis.axissaral.repository.SvpRepository;




@Service
public class EmailService {
	
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private ManagerRepository mangerRepository;
    
    @Autowired
    private SvpRepository svpRepository;
    
    
    @Autowired
    private DvpRepository dvpRepository;
    
    public void sendSimpleEmail(String body,String subject) {
    	
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("vaidyabhagyesh@gmail.com");
        message.setText(body);
        message.setSubject(subject);
        List<Employee> empList = employeeRepository.findAll();        
        for(Employee i :empList) {
        message.setTo(i.getUsername());
        mailSender.send(message);
        }
        List<Manager> managerList = mangerRepository.findAll();        
        for(Manager i :managerList) {
        message.setTo(i.getUsername());
        mailSender.send(message);
        }
        List<Dvp> dvpList = dvpRepository.findAll();        
        for(Dvp i :dvpList) {
        message.setTo(i.getUsername());
        mailSender.send(message);
        }      
        List<Svp> svpList = svpRepository.findAll();        
        for(Svp i :svpList) {
        message.setTo(i.getUsername());
        mailSender.send(message);
        }
        

    }
   
    

    
	
	
}