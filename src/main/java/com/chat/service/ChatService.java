package com.chat.service;

import java.util.List;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.chat.entity.Message;

@Component
public interface ChatService {

ResponseEntity<HashMap<String, List<Message>>>	getMessages(String sentByUserId,String sentToUserId);

ResponseEntity<HashMap<String,String>> sendMessage(Message message);

List<Message> getMessagesTest();

void save(Message messsage);

List<Message> findMessageByUserId(String sentByUserId, String sentToUserId);


}
