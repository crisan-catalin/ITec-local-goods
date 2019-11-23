package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Session;
import com.brotech.localgoods.constants.Views;
import com.brotech.localgoods.dto.CartElementDto;
import com.brotech.localgoods.dto.SessionUserDto;
import com.brotech.localgoods.form.AddToCartForm;
import com.brotech.localgoods.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private static final String CART_PRODUCTS = "cartProducts";
    private static final String CART_TOTAL_PRICE = "cartTotalPrice";

    @Autowired
    private ProductService productService;

    @GetMapping
    public String displayCart(Model model, HttpSession session) {
        SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
        if (sessionUserDto != null) {
            List<AddToCartForm> sessionOrderEntries = (ArrayList<AddToCartForm>) session.getAttribute(Session.ORDER_ENTRIES);
            if (sessionOrderEntries != null && !sessionOrderEntries.isEmpty()) {
                List<CartElementDto> cartElements = productService.getCartElements(sessionOrderEntries);
                model.addAttribute(CART_PRODUCTS, cartElements);
                session.setAttribute(Session.CART_ELEMENTS, cartElements);
                model.addAttribute(CART_TOTAL_PRICE, productService.calculateTotalPrice(cartElements));
                return Views.CART;
            } else {
                return Views.EMPTY_CART;
            }
        } else {
            return Views.LOGIN_PAGE;
        }
    }
}
