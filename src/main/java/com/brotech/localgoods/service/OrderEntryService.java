package com.brotech.localgoods.service;

import com.brotech.localgoods.model.OrderEntry;
import com.brotech.localgoods.model.Product;
import com.brotech.localgoods.repository.OrderEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
