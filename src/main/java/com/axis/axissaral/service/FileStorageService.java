package com.axis.axissaral.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.axissaral.config.JwtRequestFilter;
import com.axis.axissaral.entity.Dvp;
import com.axis.axissaral.entity.Employee;
import com.axis.axissaral.entity.FileDB;
import com.axis.axissaral.entity.Manager;
import com.axis.axissaral.entity.Svp;
import com.axis.axissaral.repository.DvpRepository;
import com.axis.axissaral.repository.EmployeeRepository;
import com.axis.axissaral.repository.FileDBRepository;
import com.axis.axissaral.repository.ManagerRepository;
import com.axis.axissaral.repository.SvpRepository;



@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;
  
 
 
  
  public FileDB storeFile(MultipartFile file,String userName) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
    FileDB.setUserName(userName);

    return fileDBRepository.save(FileDB);
  }
  

  public FileDB getFile(String name) {
		String userName = JwtRequestFilter.CURRENT_USER;
    return fileDBRepository.findBynameAnduserName(name,userName);
  }

	  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
}
