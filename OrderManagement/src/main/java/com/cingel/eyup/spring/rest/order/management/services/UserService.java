package com.cingel.eyup.spring.rest.order.management.services;

import org.springframework.stereotype.Service;

import com.cingel.eyup.spring.rest.order.management.model.User;

@Service
public interface UserService {
	public long addNewUser(User aUser);
	public boolean deleteUserById(long id);
	public boolean updateUserById(long id);
	
}
