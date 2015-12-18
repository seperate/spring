package com.cingel.eyup.spring.rest.order.management.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cingel.eyup.spring.rest.order.management.dto.UserDto;
import com.cingel.eyup.spring.rest.order.management.model.User;

@Service
public interface UserService {
	public long addNewUser(User aUser);
	public boolean deleteUserById(long id);
	public boolean updateUserById(long id, UserDto userData);
	public List<User> findAllUsers();
	public User findOneUserById(long id);
	
}
