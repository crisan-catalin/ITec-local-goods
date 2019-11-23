package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Session;
import com.brotech.localgoods.constants.Views;
import com.brotech.localgoods.dto.SessionUserDto;
import com.brotech.localgoods.form.AddToCartForm;
import com.brotech.localgoods.form.LogInUserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order-entry")
public class OrderEntryController {

    private static final String LOG_IN_USER_FORM = "logInUserForm";
    private static final String ADD_TO_CART_FORM = "addToCartForm";

    @PostMapping("/add")
    public String addOrderEntry(@ModelAttribute(ADD_TO_CART_FORM) AddToCartForm form, Model model, HttpSession session) {

        SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
        if (sessionUserDto != null) {
            List<AddToCartForm> sessionOrderEntries = (ArrayList<AddToCartForm>) session.getAttribute(Session.ORDER_ENTRIES);
            if (sessionOrderEntries != null) {
                sessionOrderEntries.add(form);
            } else {
                List<AddToCartForm> cart = new ArrayList<>();
                cart.add(form);
                sessionOrderEntries = cart;
            }

            session.setAttribute(Session.ORDER_ENTRIES, sessionOrderEntries);
            return "/" + Views.PRODUCTS_PAGE;
        } else {
            model.addAttribute(LOG_IN_USER_FORM, new LogInUserForm());
            return Views.LOGIN_PAGE;
        }
    }
}
