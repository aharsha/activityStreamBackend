package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.UserTag;

public interface UserTagDao {

	
	List<String> getAllTags(String userID);
	
	boolean subscribeUserToTag(String userID, String tag);
	
	boolean unSubscribeUserFromTag(String userID, String tag);
	
	List<String> myTags(String userID);
	
	UserTag myTagByTag(String userID, String tag);
	
	
	
}
