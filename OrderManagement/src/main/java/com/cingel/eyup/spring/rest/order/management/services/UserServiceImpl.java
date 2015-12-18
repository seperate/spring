package com.cingel.eyup.spring.rest.order.management.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cingel.eyup.spring.rest.order.management.dto.UserDto;
import com.cingel.eyup.spring.rest.order.management.model.User;
import com.cingel.eyup.spring.rest.order.management.repositories.UserRepository;

@Component
public class UserServiceImpl implements UserService{
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepo){
		this.userRepository=userRepo;
	}

	@Override
	public long addNewUser(UserDto aUser) {
		User addedUser = new User();
		addedUser.setEmail(aUser.getEmail());
		addedUser.setName(aUser.getName());
		addedUser.setPhone(aUser.getPhone());
		userRepository.save(addedUser);
		logger.info("User Saved : " + aUser.toString());
		return addedUser.getId();
	}

	@Override
	public boolean deleteUserById(long id) {
		try {
			userRepository.delete(id);
			logger.info("User with ID {"+id+"} deleted" );
			return true;
		} catch (Exception e) {
			logger.debug("Exception occured during user deletion, exception is : " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateUserById(long id, UserDto userData) {
		User foundUser = userRepository.findOne(id);
		if(foundUser != null){
			foundUser.setEmail(userData.getEmail());
			foundUser.setName(userData.getName());
			foundUser.setPhone(userData.getPhone());
		logger.info("User is updated ! " + foundUser.toString());
			return true;
		}
		return false;
	}
	
	@Override
	public List<User> findAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User findOneUserById(long id) {
		return userRepository.findOne(id);
	}

}
