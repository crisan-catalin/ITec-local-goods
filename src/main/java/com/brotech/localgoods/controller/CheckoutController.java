package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Session;
import com.brotech.localgoods.constants.Views;
import com.brotech.localgoods.dto.CartElementDto;
import com.brotech.localgoods.dto.ChargeRequest;
import com.brotech.localgoods.dto.SessionUserDto;
import com.brotech.localgoods.form.AddToCartForm;
import com.brotech.localgoods.service.OrderService;
import com.brotech.localgoods.service.ProductService;
import com.brotech.localgoods.service.StripeService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class CheckoutController {

    private static final String CART_PRODUCTS = "cartProducts";
    private static final String CART_TOTAL_PRICE = "cartTotalPrice";

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @Autowired
    private StripeService stripeService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping("cart")
    public String displayCart(Model model, HttpSession session) {
        SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
        if (sessionUserDto != null) {
            List<AddToCartForm> sessionOrderEntries = (ArrayList<AddToCartForm>) session.getAttribute(Session.ORDER_ENTRIES);
            if (sessionOrderEntries != null && !sessionOrderEntries.isEmpty()) {
                List<CartElementDto> cartElements = productService.getCartElements(sessionOrderEntries);
                model.addAttribute(CART_PRODUCTS, cartElements);
                session.setAttribute(Session.CART_ELEMENTS, cartElements);
                int totalPrice = productService.calculateTotalPrice(cartElements);
                model.addAttribute(CART_TOTAL_PRICE, totalPrice);
                model.addAttribute("amount", totalPrice * 100);
                model.addAttribute("stripePublicKey", stripePublicKey);
                model.addAttribute("currency", ChargeRequest.Currency.RON);
            }
            return Views.CART;
        } else {
            return Views.REDIRECT;
        }
    }


    @PostMapping("/charge")
    public String charge(ChargeRequest chargeRequest, HttpSession session)
            throws StripeException {
        try {
            SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
            if (sessionUserDto != null) {
                List<CartElementDto> cartElements = (ArrayList<CartElementDto>) session.getAttribute(Session.CART_ELEMENTS);
                if (cartElements != null && !cartElements.isEmpty()) {
                    orderService.placeOrder(cartElements, sessionUserDto);
                    session.removeAttribute(Session.CART_ELEMENTS);
                }

                chargeRequest.setDescription("Charge");
                chargeRequest.setCurrency(ChargeRequest.Currency.RON);
                stripeService.charge(chargeRequest);
            }
        } catch (StripeException e) {
            return Views.ORDER_PLACED;
        }
        return Views.ORDER_PLACED;
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
}