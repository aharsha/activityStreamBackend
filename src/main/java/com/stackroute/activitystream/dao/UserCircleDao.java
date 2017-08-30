package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.SubscribeCircle;



public interface UserCircleDao {
	
	public boolean subscribeToCircle(SubscribeCircle subscribeCircle);
	public boolean unSubscribeCircle(String userEmail, int circleId);
	public List<SubscribeCircle> myCircles(String userId);
	
}
