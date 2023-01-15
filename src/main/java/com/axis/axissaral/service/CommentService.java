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
	
	public void addCommentByEmployee(CommentDto commentDto) {
		Comment comment = new Comment();
		comment.setMessage(commentDto.getMessage());
		comment.setEmployee(employeeRepository.getById(commentDto.getEmpId()));		
		comment.setNewsFeed(newsFeedRepository.getById(commentDto.getFeedId()));
		commentRepository.save(comment);
	}
	
	public void addCommentByManager(CommentDto commentDto) {
		Comment comment = new Comment();
		comment.setMessage(commentDto.getMessage());
		comment.setManager(managerRepository.getById(commentDto.getEmpId()));		
		comment.setNewsFeed(newsFeedRepository.getById(commentDto.getFeedId()));
		commentRepository.save(comment);
	}

}
