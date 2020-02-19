package com.chat.entity;

public class MessageTemp {
	
	public MessageTemp() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String sentByUserId;
	private String sentToUserId;
	public MessageTemp(String sentByUserId, String sentToUserId) {
		super();
		this.sentByUserId = sentByUserId;
		this.sentToUserId = sentToUserId;
	}
	public String getSentByUserId() {
		return sentByUserId;
	}
	public void setSentByUserId(String sentByUserId) {
		this.sentByUserId = sentByUserId;
	}
	public String getSentToUserId() {
		return sentToUserId;
	}
	public void setSentToUserId(String sentToUserId) {
		this.sentToUserId = sentToUserId;
	}

}
