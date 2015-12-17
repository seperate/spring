package com.cingel.eyup.spring.rest.order.management.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserDto {
	
	private static Logger logger = LoggerFactory.getLogger(UserDto.class);
		
	private long id;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	public UserDto(){
		
	}
	
	public UserDto(long id, String name,String email,String phone){
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		
	logger.info("User instance created..." + this.toString());
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [ name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
