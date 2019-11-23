package com.brotech.localgoods.repository;

import com.brotech.localgoods.model.OrderEntry;
import org.springframework.data.repository.CrudRepository;

public interface OrderEntryRepository extends CrudRepository<OrderEntry, Long> {
}
