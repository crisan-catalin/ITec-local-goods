package com.brotech.localgoods.repository;

import com.brotech.localgoods.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
