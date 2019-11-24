package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Session;
import com.brotech.localgoods.constants.Views;
import com.brotech.localgoods.dto.CartElementDto;
import com.brotech.localgoods.dto.SessionUserDto;
import com.brotech.localgoods.enums.DeliveryStatus;
import com.brotech.localgoods.service.OrderEntryService;
import com.brotech.localgoods.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.brotech.localgoods.constants.Views.ORDER_DETAILS_PAGE;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private static final String ORDERS = "orders";
    private static final String ORDER_ENTRIES = "orderEntries";
    private static final String ORDER_DETAILS = "orderDetails";

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderEntryService orderEntryService;

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

    @GetMapping("/history")
    public String getHistory(Model model, HttpSession session) {
        SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
        if (sessionUserDto != null && !sessionUserDto.getIsSeller()) {
            model.addAttribute(ORDERS, orderService.getHistory(sessionUserDto.getId()));
            return Views.ORDERS_HISTORY;
        } else {
            return Views.REDIRECT;
        }
    }

    @GetMapping("/details/{orderId}")
    public String getProdut(@PathVariable("orderId") Long orderId, Model model, HttpSession session) {
        SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
        if (sessionUserDto != null && !sessionUserDto.getIsSeller()) {
            model.addAttribute(ORDER_DETAILS, orderService.findOrderById(orderId));
            return ORDER_DETAILS_PAGE;
        } else {
            return Views.REDIRECT;
        }
    }

    @GetMapping("/seller-history")
    public String getSellerHistory(Model model, HttpSession session) {
        SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
        if (sessionUserDto != null && sessionUserDto.getIsSeller()) {
            model.addAttribute(ORDER_ENTRIES, orderEntryService.findAllBySellerId(sessionUserDto.getId()));
            return Views.ORDER_ENTRIES_HISTORY;
        } else {
            return Views.REDIRECT;
        }
    }

    @GetMapping("/to-be-delivered")
    public String getOrdersToBeDelivered(Model model, HttpSession session) {
        SessionUserDto sessionUserDto = (SessionUserDto) session.getAttribute(Session.USER);
        if (sessionUserDto != null && sessionUserDto.getIsSeller()) {
            model.addAttribute(ORDER_ENTRIES, orderEntryService.findAllBySellerIdToBeDelivered(sessionUserDto.getId()));
            return Views.ORDER_ENTRIES_HISTORY;
        } else {
            return Views.REDIRECT;
        }
    }

    @PostMapping("/changeStatus/{orderEntryId}/{deliveryStatus}")
    public String createProduct(@PathVariable("orderEntryId") Long orderEntryId,
                                @PathVariable("deliveryStatus") DeliveryStatus deliveryStatus) {
        orderEntryService.changeOrderEntryStatus(orderEntryId, deliveryStatus);
        return Views.REDIRECT + "orders/to-be-delivered";
    }
}