package com.axis.axissaral.config;



import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.axis.axissaral.service.EmployeeService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;
	
	@Autowired
	private JwtRequestFilter jwtFilter;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(employeeService);
	}
	

	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        	.csrf()
        	.disable()
        	.cors()
        	.disable()
        	.authorizeRequests()
        	.antMatchers("/**","/department/add","/document/{documentId}","/documents/names","/documents",
        			"/add-document","/employee/upload","/manager/upload","employee/files/{name}",
        			"manager/files/{name}","/module/add","/manager/profile-image/{userId}",
        			"/employee/profile-image/{userId}","/employee/files/Get_Started_With_Smallpdf (1).pdf",
        			"/employee/upload","/send","/add","/manager","/token","/allprojects",
        			"/stakeholder/profile-image/add","/stakeHolder/add","/employee/files/employee.pdf",
        			"/manager/profile-image/add","/employee/profile-image/add","/employee/addemployee",
        			"/news/add","/feed-image/add","/feed-image/{feedId}","/allmodules").permitAll()
        	.antMatchers(HttpMethod.OPTIONS).permitAll()
        	.anyRequest().authenticated()
        	.and()
        	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        	.and()
        	.exceptionHandling().authenticationEntryPoint(entryPoint);

		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
	

}
