package com.brotech.localgoods.service;

import com.brotech.localgoods.enums.DeliveryStatus;
import com.brotech.localgoods.model.OrderEntry;
import com.brotech.localgoods.model.Product;
import com.brotech.localgoods.repository.OrderEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderEntryService {

    @Autowired
    private OrderEntryRepository orderEntryRepository;

    @Autowired
    private ProductService productService;

    public OrderEntry save(OrderEntry orderEntry) {
        return orderEntryRepository.save(orderEntry);
    }

    public List<OrderEntry> findAllBySellerId(Long sellertId) {
        List<Product> products = productService.findAllBySellerId(sellertId);
        return orderEntryRepository.findAllByProductIn(products);
    }

    public List<OrderEntry> findAllBySellerIdToBeDelivered(Long sellerId) {
        List<Product> products = productService.findAllBySellerId(sellerId);
        return orderEntryRepository.findAllByProductInAndAndDeliveryStatusIn(products, Arrays.asList(DeliveryStatus.PROCESSING, DeliveryStatus.READY_TO_SHIP));
    }

    public void changeOrderEntryStatus(Long orderEntryId, DeliveryStatus deliveryStatus) {
        OrderEntry orderEntry = orderEntryRepository.findById(orderEntryId).get();
        orderEntry.setDeliveryStatus(deliveryStatus);
        save(orderEntry);
    }
}
