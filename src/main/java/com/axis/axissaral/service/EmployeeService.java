package com.axis.axissaral.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.axis.axissaral.config.JwtRequestFilter;
import com.axis.axissaral.dto.employee.AddEmployeeDto;
import com.axis.axissaral.entity.CustomUserDetails;
import com.axis.axissaral.entity.Dvp;
import com.axis.axissaral.entity.DvpUserDetails;
import com.axis.axissaral.entity.Employee;
import com.axis.axissaral.entity.Manager;
import com.axis.axissaral.entity.ManagerUserDetails;
import com.axis.axissaral.entity.Svp;
import com.axis.axissaral.entity.SvpUserDetails;
import com.axis.axissaral.repository.DepartmentRepository;
import com.axis.axissaral.repository.DvpRepository;
import com.axis.axissaral.repository.EmployeeRepository;
import com.axis.axissaral.repository.ManagerRepository;
import com.axis.axissaral.repository.ModuleRepository;
import com.axis.axissaral.repository.ProjectRepository;
import com.axis.axissaral.repository.SvpRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service // EmployeeService is the JwtUserDetailsService..
public class EmployeeService implements UserDetailsService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	SvpRepository svpRepository;
	
	@Autowired
	DvpRepository dvpRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;


	
	
	public void addEmployee(AddEmployeeDto empdto) {
		
		
		if(empdto.getDesignation().equalsIgnoreCase("Assistant Vice President")) {
			Manager emp = new Manager();
			emp.setFirstName(empdto.getFirstName());
			emp.setLastName(empdto.getLastName());
			emp.setUsername(empdto.getUsername());
			emp.setPassword(bcryptEncoder.encode(empdto.getPassword()));
			emp.setGender(empdto.getGender());
			emp.setStatus("Active");
			emp.setMobileNumber(empdto.getMobileNumber());
			emp.setDesignation("Assistant Vice President");
			emp.setBranchName(empdto.getBranchName());
			emp.setCity(empdto.getCity());
			emp.setState(empdto.getState());
//			emp.setDepartment(departmentRepository.findBydepartmentName(empdto.getDepartment()));
			
			emp.setDepartment(dvpRepository.findByUsername(empdto.getReportingManager()).getDepartment());
			emp.setProjectName(empdto.getProjectName());
			emp.setModule(moduleRepository.findBymoduleName(empdto.getModuleName()));
			emp.setDvp(dvpRepository.findByUsername(empdto.getReportingManager()));
			
			managerRepository.save(emp);
		}else if(empdto.getDesignation().equalsIgnoreCase("Deputy Vice President"))  {
			Dvp emp = new Dvp();
			emp.setFirstName(empdto.getFirstName());
			emp.setLastName(empdto.getLastName());
			emp.setUsername(empdto.getUsername());
			emp.setPassword(bcryptEncoder.encode(empdto.getPassword()));
			emp.setGender(empdto.getGender());
			emp.setStatus("Active");
			emp.setMobileNumber(empdto.getMobileNumber());
			emp.setDesignation("Deputy Vice President");
			emp.setBranchName(empdto.getBranchName());
			emp.setCity(empdto.getCity());
			emp.setState(empdto.getState());
			emp.setDepartment(departmentRepository.findBydepartmentName(empdto.getDepartment()));
			emp.setSvp(svpRepository.findByUsername(empdto.getReportingManager()));
			
			dvpRepository.save(emp);
		}else if(empdto.getDesignation().equalsIgnoreCase("Senior Vice President"))  {
			Svp emp = new Svp();
			emp.setFirstName(empdto.getFirstName());
			emp.setLastName(empdto.getLastName());
			emp.setUsername(empdto.getUsername());
			emp.setPassword(bcryptEncoder.encode(empdto.getPassword()));
			emp.setGender(empdto.getGender());
			emp.setStatus("Active");
			emp.setMobileNumber(empdto.getMobileNumber());
			emp.setDesignation("Senior Vice President");
			emp.setBranchName(empdto.getBranchName());
			emp.setCity(empdto.getCity());
			emp.setState(empdto.getState());

			
			svpRepository.save(emp);
		}else {
			Employee emp = new Employee();
			emp.setFirstName(empdto.getFirstName());
			emp.setLastName(empdto.getLastName());
			emp.setUsername(empdto.getUsername());
			emp.setPassword(bcryptEncoder.encode(empdto.getPassword()));
			emp.setGender(empdto.getGender());
			emp.setStatus("Active");
			emp.setMobileNumber(empdto.getMobileNumber());
			emp.setDesignation(empdto.getDesignation());
			emp.setBranchName(empdto.getBranchName());
			emp.setCity(empdto.getCity());
			emp.setState(empdto.getState());
//			emp.setDepartment(departmentRepository.findBydepartmentName(empdto.getDepartment()));
			emp.setDepartment(managerRepository.findByUsername(empdto.getReportingManager()).getDepartment());

			emp.setProjectName(empdto.getProjectName());
			emp.setModule(moduleRepository.findBymoduleName(empdto.getModuleName()));
			emp.setManager(managerRepository.findByUsername(empdto.getReportingManager()));
			
			employeeRepository.save(emp);
		}

	}
	
	
	
	
	public void updateEmployee(Integer id,AddEmployeeDto empdto) {
		
		Employee emp = employeeRepository.getById(id);
		emp.setFirstName(empdto.getFirstName());
		emp.setLastName(empdto.getLastName());
		emp.setStatus(empdto.getStatus());
		emp.setMobileNumber(empdto.getMobileNumber());
		emp.setDesignation(empdto.getDesignation());
		emp.setBranchName(empdto.getBranchName());
		emp.setCity(empdto.getCity());
		emp.setState(empdto.getState());
		emp.setDepartment(managerRepository.findByUsername(empdto.getReportingManager()).getDepartment());
		emp.setProjectName(empdto.getProjectName());
		emp.setModule(moduleRepository.findBymoduleName(empdto.getModuleName()));
		emp.setManager(managerRepository.findByUsername(empdto.getReportingManager()));
		if(empdto.getDesignation().equalsIgnoreCase("Assistant Vice President") || empdto.getDesignation().equalsIgnoreCase("Deputy Vice President") || empdto.getDesignation().equalsIgnoreCase("Senior Vice President")) {
			
			if(empdto.getDesignation().equalsIgnoreCase("Assistant Vice President")) {
				Manager mgr = new Manager();
				
				mgr.setFirstName(empdto.getFirstName());
				mgr.setLastName(empdto.getLastName());
				mgr.setStatus(empdto.getStatus());
				mgr.setMobileNumber(empdto.getMobileNumber());
				mgr.setDesignation("Assistant Vice President");
				mgr.setBranchName(empdto.getBranchName());
				mgr.setCity(empdto.getCity());
				mgr.setState(empdto.getState());
				mgr.setDepartment(dvpRepository.findByUsername(empdto.getReportingManager()).getDepartment());
				mgr.setProjectName(empdto.getProjectName());
				mgr.setModule(moduleRepository.findBymoduleName(empdto.getModuleName()));
				mgr.setDvp(dvpRepository.findByUsername(empdto.getReportingManager()));
				
				managerRepository.save(mgr);
				
				employeeRepository.deleteById(emp.getId());
				
			} else if(empdto.getDesignation().equalsIgnoreCase("Deputy Vice President")){
				Dvp mgr = new Dvp();
				
				mgr.setFirstName(empdto.getFirstName());
				mgr.setLastName(empdto.getLastName());
				mgr.setStatus(empdto.getStatus());
				mgr.setMobileNumber(empdto.getMobileNumber());
				mgr.setDesignation("Deputy Vice President");
				mgr.setBranchName(empdto.getBranchName());
				mgr.setCity(empdto.getCity());
				mgr.setState(empdto.getState());
				mgr.setDepartment(departmentRepository.findBydepartmentName(empdto.getDepartment()));
//				mgr.setProjectName(empdto.getProjectName());
//				mgr.setModule(moduleRepository.findBymoduleName(empdto.getModuleName()));
				mgr.setSvp(svpRepository.findByUsername(empdto.getReportingManager()));
				
				dvpRepository.save(mgr);
				
				employeeRepository.deleteById(emp.getId());
				
				
			} else if(empdto.getDesignation().equalsIgnoreCase("Senior Vice President")) {
				Svp mgr = new Svp();
				
				mgr.setFirstName(empdto.getFirstName());
				mgr.setLastName(empdto.getLastName());
				mgr.setStatus(empdto.getStatus());
				mgr.setMobileNumber(empdto.getMobileNumber());
				mgr.setDesignation("Senior Vice President");
				mgr.setBranchName(empdto.getBranchName());
				mgr.setCity(empdto.getCity());
				mgr.setState(empdto.getState());
				//mgr.setDepartment(dvpRepository.findByUsername(empdto.getReportingManager()).getDepartment());
//				mgr.setProjectName(empdto.getProjectName());
//				mgr.setModule(moduleRepository.findBymoduleName(empdto.getModuleName()));
				//mgr.setSvp(svpRepository.findByUsername(empdto.getReportingManager()));
				
				svpRepository.save(mgr);
				
				employeeRepository.deleteById(emp.getId());
				
				
			}
		}else {
			employeeRepository.save(emp);
		}
	}
	
	
	
	
public void updateManager(Integer id,AddEmployeeDto empdto) {
		
		Manager emp = managerRepository.getById(id);
		emp.setFirstName(empdto.getFirstName());
		emp.setLastName(empdto.getLastName());
		emp.setStatus(empdto.getStatus());
		emp.setMobileNumber(empdto.getMobileNumber());
		
		emp.setBranchName(empdto.getBranchName());
		emp.setCity(empdto.getCity());
		emp.setState(empdto.getState());
		emp.setDepartment(dvpRepository.findByUsername(empdto.getReportingManager()).getDepartment());
		emp.setProjectName(empdto.getProjectName());
		emp.setModule(moduleRepository.findBymoduleName(empdto.getModuleName()));
		emp.setDvp(dvpRepository.findByUsername(empdto.getReportingManager()));
		System.out.println("h");
		
		if(!(emp.getDesignation().equals(empdto.getDesignation()))) {
			System.out.println("k");
			 if(empdto.getDesignation().equals("Deputy Vice President")) {
				Dvp mgr = new Dvp();
				
				mgr.setFirstName(empdto.getFirstName());
				mgr.setLastName(empdto.getLastName());
				mgr.setStatus(empdto.getStatus());
				mgr.setMobileNumber(empdto.getMobileNumber());
				mgr.setDesignation("Deputy Vice President");
				mgr.setBranchName(empdto.getBranchName());
				mgr.setCity(empdto.getCity());
				mgr.setState(empdto.getState());
				mgr.setDepartment(departmentRepository.findBydepartmentName(empdto.getDepartment()));
//				mgr.setProjectName(empdto.getProjectName());
//				mgr.setModule(moduleRepository.findBymoduleName(empdto.getModuleName()));
				mgr.setSvp(svpRepository.findByUsername(empdto.getReportingManager()));
				
				dvpRepository.save(mgr);
				
				managerRepository.deleteById(emp.getId());
				
				
			} else if(empdto.getDesignation().equals("Senior Vice President")) {
				Svp mgr = new Svp();
				
				mgr.setFirstName(empdto.getFirstName());
				mgr.setLastName(empdto.getLastName());
				mgr.setStatus(empdto.getStatus());
				mgr.setMobileNumber(empdto.getMobileNumber());
				mgr.setDesignation("Senior Vice President");
				mgr.setBranchName(empdto.getBranchName());
				mgr.setCity(empdto.getCity());
				mgr.setState(empdto.getState());
				//mgr.setDepartment(dvpRepository.findByUsername(empdto.getReportingManager()).getDepartment());
//				mgr.setProjectName(empdto.getProjectName());
//				mgr.setModule(moduleRepository.findBymoduleName(empdto.getModuleName()));
				//mgr.setSvp(svpRepository.findByUsername(empdto.getReportingManager()));
				
				svpRepository.save(mgr);
				
				managerRepository.deleteById(emp.getId());
				
				
			}
		}else {
			managerRepository.save(emp);
		}
	}





public void updateDvp(Integer id,AddEmployeeDto empdto) {
	
	Dvp emp = dvpRepository.getById(id);
	emp.setFirstName(empdto.getFirstName());
	emp.setLastName(empdto.getLastName());
	emp.setStatus(empdto.getStatus());
	emp.setMobileNumber(empdto.getMobileNumber());
	
	emp.setBranchName(empdto.getBranchName());
	emp.setCity(empdto.getCity());
	emp.setState(empdto.getState());
	emp.setDepartment(departmentRepository.findBydepartmentName(empdto.getDepartment()));
	
	emp.setSvp(svpRepository.findByUsername(empdto.getReportingManager()));
	
	
	if(!(emp.getDesignation().equals(empdto.getDesignation()))) {
			
		  if(empdto.getDesignation().equals("Senior Vice President")) {
			Svp mgr = new Svp();
			
			mgr.setFirstName(empdto.getFirstName());
			mgr.setLastName(empdto.getLastName());
			mgr.setStatus(empdto.getStatus());
			mgr.setMobileNumber(empdto.getMobileNumber());
			mgr.setDesignation("Senior Vice President");
			mgr.setBranchName(empdto.getBranchName());
			mgr.setCity(empdto.getCity());
			mgr.setState(empdto.getState());
			//mgr.setDepartment(dvpRepository.findByUsername(empdto.getReportingManager()).getDepartment());
//			mgr.setProjectName(empdto.getProjectName());
//			mgr.setModule(moduleRepository.findBymoduleName(empdto.getModuleName()));
			//mgr.setSvp(svpRepository.findByUsername(empdto.getReportingManager()));
			
			svpRepository.save(mgr);
			
			dvpRepository.deleteById(emp.getId());
			
			
		}
	}else {
		dvpRepository.save(emp);
	}
}



public void updateSvp(Integer id,AddEmployeeDto empdto) {
	
	Svp emp = svpRepository.getById(id);
	emp.setFirstName(empdto.getFirstName());
	emp.setLastName(empdto.getLastName());
	emp.setStatus(empdto.getStatus());
	emp.setMobileNumber(empdto.getMobileNumber());
	
	emp.setBranchName(empdto.getBranchName());
	emp.setCity(empdto.getCity());
	emp.setState(empdto.getState());
//	emp.setDepartment(departmentRepository.findBydepartmentName(empdto.getDepartment()));
//	
//	emp.setSvp(svpRepository.findByUsername(empdto.getReportingManager()));
	
	
	
		svpRepository.save(emp);
	
}
	
	
	
//	 public List<Employee> allEmployees() {
//	        return employeeRepository.findAll();
//	   }
	 
	 
	 public Employee getEmployeeByEmpID(int empID) {
		 return employeeRepository.findById(empID).get();
	 }
	 public Manager getavpByEmpID(int empID) {
		 return managerRepository.findById(empID).get();
	 }
	 public Dvp getdvpById(int empID) {
		 return dvpRepository.findById(empID).get();
	 }
	 public Svp getsvpByEmpID(int empID) {
		 return svpRepository.findById(empID).get();
	 }

	 
	

	 
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	
		
		final Employee emp = this.employeeRepository.findByUsername(username);
		if(emp==null ) {
			final Manager mng = this.managerRepository.findByUsername(username);
			if(mng==null) {
				final Dvp dvp = this.dvpRepository.findByUsername(username);
				if(dvp == null) {
					final Svp svp = this.svpRepository.findByUsername(username);
					if(svp == null)
						throw new UsernameNotFoundException("User not found !!");
					else
						return new SvpUserDetails(svp);
				}else
					return new DvpUserDetails(dvp);
			}
			else
				return new ManagerUserDetails(mng);
		}else {
			return new CustomUserDetails(emp);
		}
		
	}
	

	 public ResponseEntity<?> getCurrentEmployee() {
			String username = JwtRequestFilter.CURRENT_USER;
			Employee emp = employeeRepository.findByUsername(username);
			
			if(emp == null) {
		       Manager man = managerRepository.findByUsername(username);	
		       if(man == null) {
		    	   Dvp dvp = dvpRepository.findByUsername(username);
		    	   if(dvp == null) {
		    		   Svp svp = svpRepository.findByUsername(username);
		    		   return new ResponseEntity<>(svp, HttpStatus.OK);
		    	   }else {
		    		   return new ResponseEntity<>(dvp, HttpStatus.OK);
		    	   }
		       }else {
		    	   return new ResponseEntity<>(man, HttpStatus.OK);
		       }
			}else {
				return new ResponseEntity<>(emp, HttpStatus.OK);
			}
	 }


	 
	 
	 
}
