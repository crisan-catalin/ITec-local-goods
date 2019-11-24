package com.brotech.localgoods.repository;

import com.brotech.localgoods.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAllByUserId(Long sellerId);
}
