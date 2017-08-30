package com.stackroute.activitystream.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.stackroute.activitystream.model.User;

@Component
public interface UserDao {

	boolean addUser(User user);
	boolean updateUser(User user);
	List<User> getAllUsers();
	User getUserWithId(String emailId);
	boolean validateUser(String email,String password);
	boolean deleteUser(String email);
	
}
