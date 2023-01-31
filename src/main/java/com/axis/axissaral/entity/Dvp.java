package com.axis.axissaral.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name = "dvp")
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","FieldHandler"})
public class Dvp {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer Id;

	    @Column(name = "first_name")
	    private @NotBlank String firstName;

	    @Column(name = "last_name")
	    private @NotBlank String lastName;

	    @Column(name = "email")
	    private @NotBlank String username;
	    
	    @Column(name = "password")
	    private @NotBlank String password;
	    
	    @Column(name = "gender")
	    private @NotBlank String gender;
	    
	    @Column(name = "status")
	    private @NotBlank String status;
	    
	    
	    @Column(name = "mobile_number")
	    private  Long mobileNumber;
	    
	    @Column(name = "designation")
	    private @NotBlank String designation;
	    
	    @Column(name = "branch")
	    private  String branchName;
	    
	    @Column(name = "city")
	    private  String city;
	    
	    @Column(name = "state")
	    private  String state;
	    
//		 @JsonIgnore
//		 @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "dvp")
//		 @JoinColumn(name = "dept_id")
//		 private  Department department;
		 
		 @JsonIgnore
		 @OneToOne(cascade = CascadeType.ALL)
		 @JoinColumn(name = "dept_id",referencedColumnName = "id")
		 private  Department department;
		 
	    @JsonIgnore
		@OneToMany(mappedBy = "dvp", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		Set<Manager> managers;
		
	   
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "svp_id", nullable = false)
	    Svp svp;
	    
	    @JsonIgnore
		@OneToMany(mappedBy = "dvp",fetch = FetchType.LAZY)
		private Set<Comment> comments;
	    

		

	public Set<Comment> getComments() {
			return comments;
		}

		public void setComments(Set<Comment> comments) {
			this.comments = comments;
		}


	public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

	public Svp getSvp() {
			return svp;
		}

		public void setSvp(Svp svp) {
			this.svp = svp;
		}

	public Integer getId() {
			return Id;
		}

		public void setId(Integer id) {
			Id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Long getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(Long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getBranchName() {
			return branchName;
		}

		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public Set<Manager> getManagers() {
			return managers;
		}

		public void setManagers(Set<Manager> managers) {
			this.managers = managers;
		}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public Dvp() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}