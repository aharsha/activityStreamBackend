package com.stackroute.activitystream.dao;

import com.stackroute.activitystream.model.Circle;

public interface CircleDAO {
	
public boolean addCircle(Circle circle);
public boolean deleteCircle(int circleId);
	
	public boolean addUser(String userEmail, int circleId);
	
	public boolean removeUser(String userEmail, String circleId);
	
	
	
	public boolean updateUser(Circle circle);
	
	

}
