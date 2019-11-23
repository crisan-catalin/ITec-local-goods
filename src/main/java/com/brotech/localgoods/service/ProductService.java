package com.brotech.localgoods.service;

import com.brotech.localgoods.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductDetails(Long prodctId);
}
