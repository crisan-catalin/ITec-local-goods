package com.brotech.localgoods.service;

import com.brotech.localgoods.model.OrderEntry;
import com.brotech.localgoods.repository.OrderEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderEntryService {

    @Autowired
    private OrderEntryRepository orderEntryRepository;

    public OrderEntry save(OrderEntry orderEntry) {
        return orderEntryRepository.save(orderEntry);
    }
}
