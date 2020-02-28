package com.chat.controller;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

import com.chat.dao.MessageDao;
import com.chat.entity.Message;
import com.chat.entity.MessageTemp;
import com.chat.service.ChatService;
import com.chat.service.ChatServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChatController {
	
@Autowired
ChatService chatService;

@Autowired
MessageDao messageDao;

@GetMapping(path="/getmessage",consumes="application/json")
List<Message> getMessages(@RequestBody MessageTemp data){
	System.out.println(data.getSentByUserId());
	return messageDao.findMessageByUserId(data.getSentByUserId(), data.getSentToUserId());
}


@PostMapping(path="/saveMessage",consumes="application/json",produces="application/json")
ResponseEntity<HashMap<String, String>> saveMessage(@RequestBody Message message){
	
	return chatService.sendMessage(message);
}

@CrossOrigin
@MessageMapping("/chat/{id}")
@SendTo("/topic/messages/{id}")
ResponseEntity<List<Message>> getMessagesTest(@DestinationVariable String id,Message message){	
	System.out.println(message);
	if(message!=null)
	chatService.save(message);
	String[] users=id.split("-");
	return new ResponseEntity<List<Message>>(chatService.findMessageByUserId(users[0],users[1]),HttpStatus.OK);
}


}
