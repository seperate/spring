package com.cingel.eyup.spring.rest.order.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cingel.eyup.spring.rest.order.management.model.User;
import com.cingel.eyup.spring.rest.order.management.services.UserService;
import com.cingel.eyup.spring.rest.order.management.util.RestPreconditions;

@RestController
@RequestMapping("/user")
public class MainController {
	
	private static Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> findAll(){
		return userService.findAllUsers();
	}
	
	@RequestMapping(value = "/{userId}", method=RequestMethod.GET)
	public User findUser(@PathVariable("id") Long id){
		logger.debug("Incoming request for user id :" + id);
			try {
				return RestPreconditions.checkFound(userService.findOneUserById(id)) ;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}
}
