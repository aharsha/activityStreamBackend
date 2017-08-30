package com.stackroute.activitystream.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="subscribecircle")
public class SubscribeCircle {

	
	@Id
		private int subscriberid;
	
	
	private String userid;
	

	private int circleid;
	
	private Date dataofjoin;

	private String  status;



	public Date getDataofjoin() {
		return dataofjoin;
	}


	public void setDataofjoin(Date dataofjoin) {
		this.dataofjoin = dataofjoin;
	}


	public int getSubscriberid() {
		return subscriberid;
	}


	public void setSubscriberid(int subscriberid) {
		this.subscriberid = subscriberid;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public int getCircleid() {
		return circleid;
	}


	public void setCircleid(int circleid) {
		this.circleid = circleid;
	}
	
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	


}
