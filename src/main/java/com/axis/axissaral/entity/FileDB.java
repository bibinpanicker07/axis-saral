package com.axis.axissaral.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
public class FileDB {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  private String name;

  private String type;
  
  private String userName;

  @Lob
  private byte[] data;
  

  
  public FileDB() {
  }
  

public FileDB(String id, String name, String type, String userName, byte[] data) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.userName = userName;
	this.data = data;
}








public FileDB(String name, String type, byte[] data) {
    this.name = name;
    this.type = type;
    this.data = data;
  }
  



public String getUserName() {
	return userName;
}



public void setUserName(String userName) {
	this.userName = userName;
}



public void setId(String id) {
	this.id = id;
}

public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

}
