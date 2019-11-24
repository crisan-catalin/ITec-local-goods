package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Session;
import com.brotech.localgoods.constants.Views;
import com.brotech.localgoods.dto.SessionUserDto;
import com.brotech.localgoods.form.AddToCartForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @PostMapping("/remove/{cartEntryProductId}")
    public String removeCartEntry(@PathVariable("cartEntryProductId") Long cartEntryProductId, HttpSession session) {
        SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
        if (sessionUserDto != null) {
            List<AddToCartForm> sessionOrderEntries = (ArrayList<AddToCartForm>) session.getAttribute(Session.ORDER_ENTRIES);
            if (sessionOrderEntries != null && !sessionOrderEntries.isEmpty()) {
                sessionOrderEntries.removeIf(cartEntry -> cartEntry.getProductId() == cartEntryProductId);
                session.setAttribute(Session.ORDER_ENTRIES, sessionOrderEntries);
                return Views.REDIRECT + "cart";
            }
        }
        return Views.REDIRECT;
    }
}