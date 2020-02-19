package com.chat.service;

import java.util.List;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.chat.dao.MessageDao;
import com.chat.entity.Message;

@Component
public class ChatServiceImpl implements ChatService{
    
	@Autowired
	private MessageDao messageDao;

	
	public ResponseEntity<HashMap<String, List<Message>>> getMessages(String sentByUserId, String sentToUserId) {
		HashMap<String,List<Message>> messages=new HashMap<String,List<Message>>();
		messages.put("messages",messageDao.findAll());
		return new ResponseEntity(messages,HttpStatus.OK);
	}

	
	public ResponseEntity<HashMap<String, String>> sendMessage(Message message) {
	    HashMap<String,String> status=new HashMap<String,String>();
	    messageDao.save(message);
	    status.put("status","saved");
	    return new ResponseEntity(status,HttpStatus.ACCEPTED);
	}

	
	public List<Message> getMessagesTest() {
		return messageDao.findAll();
	}

	
	public void save(Message messsage) {
		messageDao.save(messsage);		
	}

	public List<Message> findMessageByUserId(String sentByUserId, String sentToUserId) {
		
		return messageDao.findMessageByUserId(sentByUserId,sentToUserId);
	}



}
