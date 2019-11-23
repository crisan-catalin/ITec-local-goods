package com.brotech.localgoods.repository;

import com.brotech.localgoods.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
