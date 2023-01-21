package com.axis.axissaral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.axissaral.dto.comment.CommentDto;
import com.axis.axissaral.service.CommentService;

@RestController
@CrossOrigin("http://localhost:3000")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/employee/comment/add")
	public ResponseEntity<String> addComment(@RequestBody CommentDto cmt){
		commentService.addComment(cmt);
		return new ResponseEntity<String>("Comment Added Successfully", HttpStatus.CREATED);

	}
	
//	@PostMapping("/manager/comment/add")
//	public ResponseEntity<String> addCommentByManager(@RequestBody CommentDto cmt){
//		commentService.addCommentByManager(cmt);
//		return new ResponseEntity<String>("Comment Added Successfully", HttpStatus.CREATED);
//
//	}
//	
	

}
