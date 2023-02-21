package com.udacity.c1.review.controller;

import com.udacity.c1.review.model.User;
import com.udacity.c1.review.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    private UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String getLogin(@ModelAttribute("user")User user,Model model){
        return "/signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute("user")User user, Model model){
        int user_id = 0;
        String signupError = null;
        if(userService.isUsernameAvailable(user.getUsername())){
            user_id = userService.createUser(user);
        }else{
            signupError = "The username already exists";
        }
        if(signupError == null && user_id < 0){
            signupError = "There was an error creating this user";
        }
        if(user_id > 0 ){
            model.addAttribute("signupsuccess", true);
        }else{
            model.addAttribute("signuperror", signupError );
        }
        return "/signup";
    }
}
