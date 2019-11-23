package com.brotech.localgoods.repository;

import com.brotech.localgoods.model.OrderEntry;
import com.brotech.localgoods.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderEntryRepository extends CrudRepository<OrderEntry, Long> {

    List<OrderEntry> findAllByProductIn(List<Product> products);
}
