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
  


  @PostMapping("/employee/upload")
  public ResponseEntity<ResponseMessage> uploadEmployeeFile(@RequestParam("file") MultipartFile file,@RequestParam("emp") Integer empId) {
    String message = "";
    try {
      storageService.storeEmployeeFile(file,empId);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }

  @PostMapping("/Assistant Vice President/upload")
  public ResponseEntity<ResponseMessage> uploadManagerFile(@RequestParam("file") MultipartFile file,@RequestParam("manager") Integer managerId) {
    String message = "";
    try {
  
      storageService.storeManagerFile(file,managerId);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }
  
  @PostMapping("/Deputy Vice President/upload")
  public ResponseEntity<ResponseMessage> uploaddvpFile(@RequestParam("file") MultipartFile file,@RequestParam("manager") Integer managerId) {
    String message = "";
    try {
  
      storageService.storeDvpFile(file,managerId);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }
  
  @PostMapping("/Senior Vice President/upload")
  public ResponseEntity<ResponseMessage> uploadsvoFile(@RequestParam("file") MultipartFile file,@RequestParam("manager") Integer managerId) {
    String message = "";
    try {
  
      storageService.storeSvpFile(file,managerId);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }
  
//  @GetMapping("/files")
//  public ResponseEntity<List<ResponseFile>> getListFiles() {
//    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
//      String fileDownloadUri = ServletUriComponentsBuilder
//          .fromCurrentContextPath()
//          .path("/files/")
//          .path(dbFile.getId())
//          .toUriString();
//
//      return new ResponseFile(
//          dbFile.getName(),
//          fileDownloadUri,
//          dbFile.getType(),
//          dbFile.getData().length);
//    }).collect(Collectors.toList());
//
//    return ResponseEntity.status(HttpStatus.OK).body(files);
//  }

	 

  
  
  
  
  
  
  
  @GetMapping("/employee/files/{name}")
  public ResponseEntity<byte[]> getEmployeeFile(@PathVariable String name) {
	  
    FileDB fileDB = storageService.getEmployeeFile(name);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }
  @GetMapping("/Assistant Vice President/files/{name}")
  public ResponseEntity<byte[]> getManagerFile(@PathVariable String name) {
	
    FileDB fileDB = storageService.getManagerFile(name);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }
  @GetMapping("/Deputy Vice President/files/{name}")
  public ResponseEntity<byte[]> getdvpFile(@PathVariable String name) {
	  
    FileDB fileDB = storageService.getDvpFile(name);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }
  @GetMapping("/Senior Vice President/files/{name}")
  public ResponseEntity<byte[]> getsvpFile(@PathVariable String name) {
	  
    FileDB fileDB = storageService.getSvpFile(name);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }
}
