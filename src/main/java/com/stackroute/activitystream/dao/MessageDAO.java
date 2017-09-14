package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.model.UserOutBox;



public interface MessageDAO 
{

	boolean sendMessage(UserOutBox message);
	
	
	List<Message> inBox(String userId);
	List<Message> circleInBox(int circleId);
}
