package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Session;
import com.brotech.localgoods.constants.Views;
import com.brotech.localgoods.dto.SessionUserDto;
import com.brotech.localgoods.form.UserInfoForm;
import com.brotech.localgoods.model.Address;
import com.brotech.localgoods.model.User;
import com.brotech.localgoods.repository.AddressRepository;
import com.brotech.localgoods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final String USER_DETAILS = "userDetails";
    private static final String USER_INFO_FORM = "userInfoForm";

    @Autowired
    private UserService userService;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/{userId}")
    public String getUserProfile(@PathVariable Long userId, Model model) {
        model.addAttribute(USER_DETAILS, userService.getUserById(userId));
        return Views.USER_PROFILE;
    }

    @GetMapping("/account")
    public String getMyAccountInfo(Model model, HttpSession session) {
        SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
        if (sessionUserDto != null) {
            model.addAttribute(USER_DETAILS, userService.getUserById(sessionUserDto.getId()));
            model.addAttribute(USER_INFO_FORM, new UserInfoForm());
            return Views.MY_ACCOUNT;
        }
        return Views.REDIRECT + Views.LOGIN_PAGE;
    }

    @PostMapping("/account")
    public String updateMyAccountInfo(@ModelAttribute(USER_INFO_FORM) UserInfoForm form, HttpSession session) {
        User user;
        if (StringUtils.isEmpty(form.getOldPassword()) && StringUtils.isEmpty(form.getNewPassword())) {
            SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
            if (sessionUserDto != null) {
                user = userService.getUserById(sessionUserDto.getId());
            } else {
                return Views.REDIRECT + "user/account";
            }
        } else {
            user = userService.getUserByEmailAndPassword(form.getEmail(), form.getOldPassword());
        }

        Address userAddress = user.getAddress();
        userAddress.setCity(form.getCity());
        userAddress.setStreet(form.getStreet());
        userAddress.setNumber(form.getNumber());
        userAddress = addressRepository.save(userAddress);

        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPhone(form.getPhone());
        user.setPassword(form.getNewPassword());
        user.setAddress(userAddress);
        userService.save(user);
        return Views.REDIRECT + "user/account";
    }

}
