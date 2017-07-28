package com.stackroute.activitystream.model;


import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class SubscribeCircle {

	
	@Id
		private int subscriberId;
	
	
	private String userId;
	

	private int circleId;
	
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


	public int getCircleId() {
		return circleId;
	}


	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}


	


}
