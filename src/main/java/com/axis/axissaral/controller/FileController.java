package com.axis.axissaral.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.axis.axissaral.entity.Employee;
import com.axis.axissaral.entity.FileDB;
import com.axis.axissaral.entity.Manager;
import com.axis.axissaral.message.ResponseFile;
import com.axis.axissaral.message.ResponseMessage;
import com.axis.axissaral.repository.EmployeeRepository;
import com.axis.axissaral.repository.ManagerRepository;
import com.axis.axissaral.service.FileStorageService;



@RestController
@CrossOrigin("http://localhost:3000")
public class FileController {

  @Autowired
  private FileStorageService storageService;
  


  @PostMapping("/file/upload")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("emp") String userName) {
    String message = "";
    try {
      storageService.storeFile(file,userName);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }
  @GetMapping("/file/{name}")
  public ResponseEntity<byte[]> getFile(@PathVariable String name) {
	  
    FileDB fileDB = storageService.getFile(name);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }


}
