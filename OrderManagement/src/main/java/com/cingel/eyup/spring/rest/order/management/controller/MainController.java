package com.cingel.eyup.spring.rest.order.management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cingel.eyup.spring.rest.order.management.model.User;

@RestController
public class MainController {
	
	@RequestMapping("/index")
	public User context(){
		return new User(1,"Eyup","e@b.com","05423872909");
	}
}
