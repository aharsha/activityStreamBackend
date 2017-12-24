package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.model.UserOutBox;



public interface MessageDAO 
{

	boolean sendMessage(UserOutBox message);
	
	boolean sendMessageToCircle(UserOutBox message);
	List<UserOutBox> inBox(String friend,String user);
	List<UserOutBox> circleInBox(int circleId);
}
