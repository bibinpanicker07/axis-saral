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

  @Lob
  private byte[] data;
  
  @ManyToOne()
  @JoinColumn(name = "employee_id", referencedColumnName = "id")
  private Employee employee;

  @ManyToOne()
  @JoinColumn(name = "manager_id", referencedColumnName = "id")
  private Manager manager;
  
  public FileDB() {
  }

  public FileDB(String name, String type, byte[] data) {
    this.name = name;
    this.type = type;
    this.data = data;
  }
  

  public FileDB(String name, String type, byte[] data, Employee employee, Manager manager) {
	super();
	this.name = name;
	this.type = type;
	this.data = data;
	this.employee = employee;
	this.manager = manager;
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

public Manager getManager() {
	return manager;
}

public void setManager(Manager manager) {
	this.manager = manager;
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
