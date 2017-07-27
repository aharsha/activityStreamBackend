package com.stackroute.activitystream.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Circle {
	@Id
	private int circleId;
	
private String circleName,ownerId,circleDiscription,status;



	
	private Date createdDate;
	
	public int getCircleId() {
		return circleId;
	}

	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCircleDiscription() {
		return circleDiscription;
	}

	public void setCircleDiscription(String circleDiscription) {
		this.circleDiscription = circleDiscription;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
	

	
	
}
