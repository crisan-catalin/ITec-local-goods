package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Views;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{userId}")
    public String getUserProfile(@PathVariable Long userId){
        return Views.USER_PROFILE;
    }
}
