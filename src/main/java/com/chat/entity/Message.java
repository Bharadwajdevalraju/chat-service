package com.chat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long messageId;
private String sentByUserId;
private String sentByUserName;
private String sentToUserId;
private String sentToUserName;
private String message;
private String time;
public Message() {
	super();
}


public Message(long messageId, String sentByUserId, String sentByUserName, String sentToUserId, String sentToUserName,
		String message, String time) {
	super();
	this.messageId = messageId;
	this.sentByUserId = sentByUserId;
	this.sentByUserName = sentByUserName;
	this.sentToUserId = sentToUserId;
	this.sentToUserName = sentToUserName;
	this.message = message;
	this.time = time;
}

public long getMessageId() {
	return messageId;
}
public void setMessageId(long messageId) {
	this.messageId = messageId;
}
public String getSentByUserId() {
	return sentByUserId;
}
public void setSentByUserId(String sentByUserId) {
	this.sentByUserId = sentByUserId;
}
public String getSentByUserName() {
	return sentByUserName;
}
public void setSentByUserName(String sentByUserName) {
	this.sentByUserName = sentByUserName;
}
public String getSentToUserId() {
	return sentToUserId;
}

public void setSentToUserId(String sentToUserId) {
	this.sentToUserId = sentToUserId;
}

public String getSentToUserName() {
	return sentToUserName;
}

public void setSentToUserName(String sentToUserName) {
	this.sentToUserName = sentToUserName;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}


}

