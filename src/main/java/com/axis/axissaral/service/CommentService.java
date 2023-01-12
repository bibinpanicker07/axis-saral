package com.axis.axissaral.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.axissaral.dto.comment.CommentDto;
import com.axis.axissaral.entity.Comment;
import com.axis.axissaral.repository.CommentRepository;
import com.axis.axissaral.repository.EmployeeRepository;
import com.axis.axissaral.repository.ManagerRepository;
import com.axis.axissaral.repository.NewsFeedRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	NewsFeedRepository newsFeedRepository;
	
	public void addComment(CommentDto commentDto) {
		Comment comment = new Comment();
		comment.setMessage(commentDto.getMessage());
		if(employeeRepository.findById(commentDto.getEmpId()).isPresent())
		comment.setEmployee(employeeRepository.getById(commentDto.getEmpId()));
		if(managerRepository.findById(commentDto.getManagerId()).isPresent())
		comment.setManager(managerRepository.findById(commentDto.getManagerId()).get());
		
		comment.setNewsFeed(newsFeedRepository.getById(commentDto.getFeedId()));
		commentRepository.save(comment);
	}

}
