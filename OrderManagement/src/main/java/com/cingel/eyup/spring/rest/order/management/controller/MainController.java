package com.cingel.eyup.spring.rest.order.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cingel.eyup.spring.rest.order.management.dto.UserDto;
import com.cingel.eyup.spring.rest.order.management.model.User;
import com.cingel.eyup.spring.rest.order.management.services.UserService;

@RestController
@RequestMapping("/user")
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAllUsers(){
		return userService.findAllUsers();
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public Long addUser(UserDto user){
		return userService.addNewUser(user);
	}

}
