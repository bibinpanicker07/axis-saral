package com.axis.axissaral.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.axissaral.config.JwtRequestFilter;
import com.axis.axissaral.dto.comment.CommentDto;
import com.axis.axissaral.entity.Comment;
import com.axis.axissaral.repository.CommentRepository;
import com.axis.axissaral.repository.DvpRepository;
import com.axis.axissaral.repository.EmployeeRepository;
import com.axis.axissaral.repository.ManagerRepository;
import com.axis.axissaral.repository.NewsFeedRepository;
import com.axis.axissaral.repository.SvpRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	DvpRepository dvpRepository;
	
	@Autowired
	SvpRepository svpRepository;
	
	@Autowired
	NewsFeedRepository newsFeedRepository;

//	public void addComment(CommentDto commentDto) {
//		String user = JwtRequestFilter.CURRENT_USER;
//		Comment comment = new Comment();
//		comment.setMessage(commentDto.getMessage());
//		if(employeeRepository.findByUsername(user) == null) {
//			comment.setManager(managerRepository.findByUsername(user));		
//		}else {
//		comment.setEmployee(employeeRepository.findByUsername(user));	
//		}
//		comment.setNewsFeed(newsFeedRepository.getById(commentDto.getFeedId()));
//		commentRepository.save(comment);
//	}
	
	
	public void addComment(CommentDto commentDto) {
		String user = JwtRequestFilter.CURRENT_USER;
		Comment comment = new Comment();
		comment.setMessage(commentDto.getMessage());
		if(employeeRepository.findByUsername(user) == null) {
			if(managerRepository.findByUsername(user) == null) {
				if(dvpRepository.findByUsername(user) == null) {
					comment.setSvp(svpRepository.findByUsername(user));
				}else {
					comment.setDvp(dvpRepository.findByUsername(user));
				}
			}else {
				comment.setManager(managerRepository.findByUsername(user));	
			}
		}else {
		comment.setEmployee(employeeRepository.findByUsername(user));	
		}
		comment.setNewsFeed(newsFeedRepository.getById(commentDto.getFeedId()));
		commentRepository.save(comment);
	}
	
	

	
	
	
	
	
	

}
