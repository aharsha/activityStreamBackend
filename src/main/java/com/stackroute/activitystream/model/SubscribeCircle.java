package com.stackroute.activitystream.model;

import javax.annotation.Generated;
import javax.persistence.Id;

public class SubscribeCircle {

	
	@Id
		private int subscriberId;
	
	
	private String userId;
	

	private String circleId;
	
	public int getSubscriberId() {
		return subscriberId;
	}


	public void setSubscriberId(int subscriberId) {
		this.subscriberId = subscriberId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getCircleId() {
		return circleId;
	}


	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}


}
