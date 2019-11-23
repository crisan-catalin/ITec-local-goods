package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Session;
import com.brotech.localgoods.constants.Views;
import com.brotech.localgoods.dto.SessionUserDto;
import com.brotech.localgoods.form.AddToCartForm;
import com.brotech.localgoods.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private static final String CART_PRODUCTS = "cartProducts";

    @Autowired
    private ProductService productService;

    public String displayCart(Model model, HttpSession session) {
        SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
        if (sessionUserDto != null) {
            List<AddToCartForm> sessionOrderEntries = (ArrayList<AddToCartForm>) session.getAttribute(Session.ORDER_ENTRIES);
            if (sessionOrderEntries != null && !sessionOrderEntries.isEmpty()) {
                model.addAttribute(CART_PRODUCTS, productService.getCartElements(sessionOrderEntries));
            }
        }

        return Views.MAIN_PAGE;
    }
}
