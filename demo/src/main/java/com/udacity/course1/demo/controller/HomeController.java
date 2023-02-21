package com.udacity.course1.demo.controller;

import com.udacity.course1.demo.model.MessageForm;
import com.udacity.course1.demo.services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class HomeController {
    private MessageService messageService;

    public HomeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/home")
    public String getHome(@ModelAttribute("newMessage") MessageForm messageForm, Model model){
        model.addAttribute("welcomeMessage", "Hi Hello"+ Instant.now().toString());
        model.addAttribute("greetings", messageService.getMessageList());
        return "/home";
    }

    @PostMapping("/home")
    public String postHome(@ModelAttribute("newMessage") MessageForm messageForm, Model model){
        messageService.addMessage(messageForm.getText());
        model.addAttribute("welcomeMessage", "Hi Hello"+ Instant.now().toString());
        model.addAttribute("greetings", messageService.getMessageList());
        messageForm.setText("");
        return "/home";
    }

//    @RequestMapping("/secondhome")
    @GetMapping("secondhome")
    public String getSecondHome(Model model){
        model.addAttribute("firstVisit", true);
        return "/secondhome";
    }
    @PostMapping("secondhome")
    public String getSecondPHome(Model model){
        model.addAttribute("firstVisit", false);
        return "/secondhome";
    }
}
