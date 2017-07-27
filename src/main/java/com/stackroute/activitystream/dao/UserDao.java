package com.stackroute.activitystream.dao;


import com.stackroute.activitystream.model.User;

public interface UserDao {

	boolean addUser(User user);
	boolean updateUser(User user);
	boolean validateUser(String email,String password);
	boolean deleteUser(String email);
	
}
