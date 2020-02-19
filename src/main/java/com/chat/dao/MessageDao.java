package com.chat.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.chat.entity.Message;

@Component
public interface MessageDao extends JpaRepository<Message,String>{
public ArrayList<Message> findAll();

@Query("SELECT u FROM Message u WHERE (sentByUserId=?1 and sentToUserId=?2) or (sentByUserId=?2 and sentToUserId=?1)")
List<Message> findMessageByUserId(String sentById, String sentToId);
}
