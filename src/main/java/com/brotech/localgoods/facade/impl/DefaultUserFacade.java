package com.brotech.localgoods.facade.impl;

import com.brotech.localgoods.dto.SessionUserDto;
import com.brotech.localgoods.facade.AddressFacade;
import com.brotech.localgoods.facade.UserFacade;
import com.brotech.localgoods.form.LogInUserForm;
import com.brotech.localgoods.form.RegisterForm;
import com.brotech.localgoods.model.User;
import com.brotech.localgoods.service.AddressService;
import com.brotech.localgoods.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class DefaultUserFacade implements UserFacade {

    @Autowired
    private AddressFacade addressFacade;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Override
    public SessionUserDto logInUser(LogInUserForm logInUserForm) {
        User user = userService.getUserByEmailAndPassword(logInUserForm.getEmail(), logInUserForm.getPassword());
        if (user != null) {
            return convertToSessionUser(user);
        } else {
            return null;
        }
    }

    @Override
    public boolean registerUser(RegisterForm registerForm) {
        User savedUser = userService.save(convertRegisterFormToUser(registerForm));
        return savedUser != null;
    }

    private SessionUserDto convertToSessionUser(User user) {
        SessionUserDto sessionUserDto = new SessionUserDto();
        sessionUserDto.setId(user.getId());
        sessionUserDto.setName(user.getName());
        sessionUserDto.setIsSeller(user.getIsSeller());
        return sessionUserDto;
    }

    private User convertRegisterFormToUser(RegisterForm registerForm) {
        User user = new User();
        user.setName(registerForm.getName());
        user.setPhone(registerForm.getPhone());
        user.setEmail(registerForm.getEmail());
        user.setPassword(registerForm.getPassword());
        user.setAddress(addressService.save(addressFacade.convertToAddress(registerForm.getAddress())));
        user.setIsSeller(registerForm.getIsSeller());
        user.setType(registerForm.getType());
        return user;
    }
}
