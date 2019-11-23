package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Session;
import com.brotech.localgoods.constants.Views;
import com.brotech.localgoods.dto.CartElementDto;
import com.brotech.localgoods.dto.SessionUserDto;
import com.brotech.localgoods.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public String placeOrder(HttpSession session) {
        SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
        if (sessionUserDto != null) {
            List<CartElementDto> cartElements = (ArrayList<CartElementDto>) session.getAttribute(Session.CART_ELEMENTS);
            if (cartElements != null && !cartElements.isEmpty()) {
                orderService.placeOrder(cartElements, sessionUserDto);
                return Views.ORDER_PLACED;
            } else {
                return Views.EMPTY_CART;
            }
        } else {
            return Views.REDIRECT;
        }
    }
}