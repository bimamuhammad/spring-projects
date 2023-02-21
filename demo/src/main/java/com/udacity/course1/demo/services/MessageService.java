package com.udacity.course1.demo.services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageService {
    private ArrayList<String> messageList;

    @PostConstruct
    public void postConstruct(){
        this.messageList = new ArrayList<>();
    }
    public void addMessage(String message){
        messageList.add(message);
    }

    public ArrayList<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<String> messageList) {
        this.messageList = messageList;
    }
}
