package com.brotech.localgoods.repository;

import com.brotech.localgoods.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAllByCustomer_Id(Long customerId);
}
