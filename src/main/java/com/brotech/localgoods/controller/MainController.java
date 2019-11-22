package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Session;
import com.brotech.localgoods.constants.Views;
import com.brotech.localgoods.dto.SessionUserDto;
import com.brotech.localgoods.facade.impl.DefaultUserFacade;
import com.brotech.localgoods.form.LogInUserForm;
import com.brotech.localgoods.form.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping
public class MainController {

    private static final String LOG_IN_USER_FORM = "logInUserForm";
    private static final String REGISTER_FORM = "registerForm";
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String INFO_MESSAGE = "infoMessage";
    private static final String REDIRECT = "redirect:/";

    @Autowired
    private DefaultUserFacade userFacade;

    @GetMapping("/")
    public String getHomePage() {
        return Views.MAIN_PAGE;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model, HttpSession session) {

        SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
        if (sessionUserDto != null) {
            return Views.MAIN_PAGE;
        } else {
            model.addAttribute(LOG_IN_USER_FORM, new LogInUserForm());
            return Views.LOGIN_PAGE;
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logInUser(@NotNull @ModelAttribute(LOG_IN_USER_FORM) LogInUserForm logInUserForm, Model model, HttpSession session) {
        SessionUserDto sessionUserDto = userFacade.logInUser(logInUserForm);
        if (sessionUserDto != null) {
            session.setAttribute(Session.USER, sessionUserDto);
            return Views.MAIN_PAGE;
        } else {
            model.addAttribute(ERROR_MESSAGE, "Incorrect combination of email and password.");
            return Views.LOGIN_PAGE;
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String getLogoutPage(HttpSession session) {
        session.removeAttribute(Session.USER);
        return REDIRECT;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model) {
        model.addAttribute(REGISTER_FORM, new RegisterForm());
        return Views.REGISTER_PAGE;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@NotNull @ModelAttribute(REGISTER_FORM) RegisterForm registerForm, Model model, RedirectAttributes attributes) {
        if (userFacade.registerUser(registerForm)) {
            attributes.addFlashAttribute(INFO_MESSAGE, "User created successfully! Please log in with email and password.");
            return REDIRECT + "login";
        } else {
            model.addAttribute(ERROR_MESSAGE, "User couldn't be created. Please try again.");
            return Views.REGISTER_PAGE;
        }
    }
}
