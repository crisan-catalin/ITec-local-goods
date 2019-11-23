package com.brotech.localgoods.service;

import com.brotech.localgoods.dto.CartElementDto;
import com.brotech.localgoods.dto.SessionUserDto;
import com.brotech.localgoods.enums.DeliveryStatus;
import com.brotech.localgoods.model.Order;
import com.brotech.localgoods.model.OrderEntry;
import com.brotech.localgoods.model.User;
import com.brotech.localgoods.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEntryService orderEntryService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getHistory(Long customerId){
        return orderRepository.findAllByCustomer_Id(customerId);
    }

    public void placeOrder(List<CartElementDto> cartElements, SessionUserDto sessionUserDto) {
        User user = userService.getUserById(sessionUserDto.getId());
        Order order = new Order();
        order.setCustomer(user);
        order.setDeliveryAddress(user.getAddress());
        order.setDeliveryStatus(DeliveryStatus.PROCESSING);
        order.setTotalPrice(Long.valueOf(productService.calculateTotalPrice(cartElements)));
        save(order);

        cartElements.forEach(cartElementDto -> orderEntryService.save(createOrderEntry(cartElementDto, order)));
    }

    private OrderEntry createOrderEntry(CartElementDto cartElementDto, Order order) {
        OrderEntry orderEntry = new OrderEntry();
        orderEntry.setOrder(order);
        orderEntry.setProduct(productService.getProductDetails(cartElementDto.getProductId()));
        orderEntry.setQuantity(cartElementDto.getQuantity());
        orderEntry.setTotalPrice(cartElementDto.getTotalPrice());
        return orderEntry;
    }
}
