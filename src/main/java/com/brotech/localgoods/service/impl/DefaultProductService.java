package com.brotech.localgoods.service.impl;

import com.brotech.localgoods.dto.CartElementDto;
import com.brotech.localgoods.form.AddToCartForm;
import com.brotech.localgoods.model.Product;
import com.brotech.localgoods.repository.ProductRepository;
import com.brotech.localgoods.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<Product> getCartProducts(List<AddToCartForm> cartProducts) {
        List<Product> products = new ArrayList<>();
        cartProducts.forEach(cartProduct -> productRepository.findById(Long.valueOf(cartProduct.getProductId())).ifPresent(products::add));
        return products;
    }

    @Override
    public List<CartElementDto> getCartElements(List<AddToCartForm> cartProducts) {
        List<Product> products = getCartProducts(cartProducts);

        return null;
    }

    private CartElementDto createCartElement(Product product, AddToCartForm form){
        CartElementDto cartElementDto = new CartElementDto();
        cartElementDto.setProductId(product.getId());
        cartElementDto.setProductName(product.getName());
        cartElementDto.setQuantity(form.getQuantity());
        cartElementDto.setTotalPrice(calculatePrice(product,form.getQuantity()));
    }

    private Long calculatePrice(Product product, int quantity){

    }
}
