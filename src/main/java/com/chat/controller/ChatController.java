package com.chat.controller;

import java.util.List;
import java.util.HashMap;

import com.chat.dao.MessageDao;
import com.chat.entity.Message;
import com.chat.entity.MessageTemp;
import com.chat.service.ChatService;
import com.chat.service.ChatServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@MessageMapping("/chat")
@SendTo("/topic/messages")
ResponseEntity<List<Message>> getMessagesTest(Message message){
	chatService.save(message);
	return this.getMessagesTest(new MessageTemp(message.getSentByUserId(),message.getSentToUserId()));
}

@CrossOrigin
@MessageMapping("/")
@SendTo("/topic/messages")
ResponseEntity<List<Message>> getMessagesTest(MessageTemp data){
	return new ResponseEntity<List<Message>>(chatService.findMessageByUserId(data.getSentByUserId(), data.getSentToUserId()),HttpStatus.OK);
}

}
