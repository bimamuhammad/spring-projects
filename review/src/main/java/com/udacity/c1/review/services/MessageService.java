package com.udacity.c1.review.services;

import com.udacity.c1.review.mapper.MessageMapper;
import com.udacity.c1.review.model.ChatMessage;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class MessageService {
    private String message;
    private List<ChatMessage> chatMessages;
    private MessageMapper messageMapper;

    public MessageService(String message, MessageMapper messageMapper){
        this.message = message;
        this.messageMapper = messageMapper;
    }
    @PostConstruct
    public void postContruct(){
        chatMessages = new ArrayList<>();
    }

    public void addMessage(ChatMessage chatMessage){
        messageMapper.registerMessage(chatMessage);
    }
    public List<ChatMessage> getChatMessages(){
        return messageMapper.getMessages();
    }
    public String uppercaseMessage(){
        return message.toUpperCase(Locale.ROOT);
    }
    public String lowercaseMessage(){
        return message.toLowerCase(Locale.ROOT);
    }
}
