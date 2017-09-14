package com.stackroute.activitystream.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="message")
public class Message {

	@Id
	private int id;
	
	@Column(name="senderid")
	private String senderId;
	
	@Column(name="recieverid")
	private String recieverId;
	
	@Column(name="messagetype")
	private String messageType;
	
	@Column(name="messagecontent")
	private String messageContent;
	
	@Column(name="messagetime")
	Date messageTime;
	
	@Column(name="recievercircleid")
	int recieverCircleId;
	
	@Column(name="tag")
	String tag;

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getRecieverCircleId() {
		return recieverCircleId;
	}

	public void setRecieverCircleId(int recieverCircleId) {
		this.recieverCircleId = recieverCircleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getRecieverId() {
		return recieverId;
	}

	public void setRecieverId(String recieverId) {
		this.recieverId = recieverId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}
	
	
		

	public String getTag() {
		return tag;
	}
	
}
