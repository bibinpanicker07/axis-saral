package com.axis.axissaral.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.axissaral.config.JwtRequestFilter;
import com.axis.axissaral.entity.Employee;
import com.axis.axissaral.entity.FileDB;
import com.axis.axissaral.entity.Manager;
import com.axis.axissaral.repository.EmployeeRepository;
import com.axis.axissaral.repository.FileDBRepository;
import com.axis.axissaral.repository.ManagerRepository;



@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;
  
  @Autowired
  private EmployeeRepository employeeRepository;
  
  @Autowired
  private ManagerRepository managerRepository;

  public FileDB storeEmployeeFile(MultipartFile file,Integer empId) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
    FileDB.setEmployee(employeeRepository.getById(empId));

    return fileDBRepository.save(FileDB);
  }
  
  public FileDB storeManagerFile(MultipartFile file,Integer managerId) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
	    FileDB.setManager(managerRepository.getById(managerId));

	    return fileDBRepository.save(FileDB);
	  }

  public FileDB getEmployeeFile(String name) {
		String user = JwtRequestFilter.CURRENT_USER;
	  Employee emp = employeeRepository.findByUsername(user);
    return fileDBRepository.findBynameAndEmployee(name, emp);
  }
  public FileDB getManagerFile(String name) {
		String user = JwtRequestFilter.CURRENT_USER;
		  Manager emp = managerRepository.findByUsername(user);
	    return fileDBRepository.findBynameAndManager(name, emp);
	  }
	  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
}
