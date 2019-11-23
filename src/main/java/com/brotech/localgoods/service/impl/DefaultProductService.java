package com.brotech.localgoods.service.impl;

import com.brotech.localgoods.model.Product;
import com.brotech.localgoods.repository.ProductRepository;
import com.brotech.localgoods.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductDetails(Long prodctId) {
        Optional<Product> product = productRepository.findById(prodctId);
        return product.orElseGet(Product::new);
    }
}
