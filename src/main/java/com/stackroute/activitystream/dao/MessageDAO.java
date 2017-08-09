package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.Message;

public interface MessageDAO 
{

	boolean sendMessage(String reciever,Message message);
	boolean sendMessageCircle(int circleId,Message message);
	
	List<Message> inBox(String userId);
	List<Message> circleInBox(int circleId);
}
