package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Views;
import com.brotech.localgoods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final String USER_DETAILS = "userDetails";

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public String getUserProfile(@PathVariable Long userId, Model model) {
        model.addAttribute(USER_DETAILS, userService.getUserById(userId));
        return Views.USER_PROFILE;
    }
}
