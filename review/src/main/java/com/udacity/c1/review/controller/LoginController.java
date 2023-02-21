package com.udacity.c1.review.controller;

import com.udacity.c1.review.model.LoginFormData;
import com.udacity.c1.review.services.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(Model model){
        return "/login";
    }

}
