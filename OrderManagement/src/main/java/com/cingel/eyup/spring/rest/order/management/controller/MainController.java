package com.cingel.eyup.spring.rest.order.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cingel.eyup.spring.rest.order.management.dto.UserDto;
import com.cingel.eyup.spring.rest.order.management.model.User;
import com.cingel.eyup.spring.rest.order.management.services.UserService;

@RestController
@RequestMapping("/user")
public class MainController {
	
	private static Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAllUsers(){
		
		List<User> users = userService.findAllUsers();
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<Long> addUser(User user, UriComponentsBuilder ucBuilder){
		log.info("Creating user : " + user.getName());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		try{
		userService.addNewUser(user);
		return new ResponseEntity<Long>(headers,HttpStatus.CREATED);
		}catch(Exception e){
		log.info("Exception occured when saving incoming User :" + user.toString() + "Exception is :" +e.getMessage());
		return new ResponseEntity<Long>(headers,HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
	{
		log.info("Fetching user for incoming id : " + id);
		User user = userService.findOneUserById(id);
		
	if(user == null){
		log.info("User with id :" + id +" not found");
		return new ResponseEntity<User> (HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	

}
