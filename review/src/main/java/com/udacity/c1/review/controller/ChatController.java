package com.udacity.c1.review.controller;

import com.udacity.c1.review.model.ChatForm;
import com.udacity.c1.review.model.ChatMessage;
import com.udacity.c1.review.model.User;
import com.udacity.c1.review.services.AuthenticationService;
import com.udacity.c1.review.services.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {

    private MessageService messageService;
    private String username;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping("/chat")
    public String getChatPage(@ModelAttribute("chatMessage") ChatForm chatForm, Model model){
        model.addAttribute("messages", messageService.getChatMessages() );
        return "chat";
    }
    @PostMapping("/chat")
    public String postChatPage(@ModelAttribute("chatMessage") ChatForm chatForm, Model model, Authentication authentication){
        ChatMessage chatMessage = new ChatMessage();
        chatForm.setUsername(authentication.getName());
        switch (chatForm.getMessageType()) {
            case "Say" -> chatMessage.setMessageText(chatForm.getMessage());
            case "Shout" -> chatMessage.setMessageText(chatForm.getMessage().toUpperCase());
            case "Whisper" -> chatMessage.setMessageText(chatForm.getMessage().toLowerCase());
            default -> {
            }
        }
        messageService.addMessage(chatMessage);
        model.addAttribute("messages", messageService.getChatMessages() );
        return "/chat";
    }
}
