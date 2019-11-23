package com.brotech.localgoods.service.impl;

import com.brotech.localgoods.dto.CartElementDto;
import com.brotech.localgoods.form.AddToCartForm;
import com.brotech.localgoods.model.PriceInterval;
import com.brotech.localgoods.model.Product;
import com.brotech.localgoods.repository.ProductRepository;
import com.brotech.localgoods.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public List<CartElementDto> getCartElements(List<AddToCartForm> cartProducts) {
        Map<AddToCartForm, Product> productsMap = getCartProducts(cartProducts);
        List<CartElementDto> cartElements = new ArrayList<>();
        productsMap.forEach((key, value) -> cartElements.add(createCartElement(value, key)));
        return cartElements;
    }

    @Override
    public List<Product> findAllBySellerId(Long sellerId) {
        return productRepository.findAllByUser(sellerId);
    }

    private Map<AddToCartForm, Product> getCartProducts(List<AddToCartForm> cartForms) {
        Map<AddToCartForm, Product> productsMap = new HashMap<>();
        cartForms.forEach(cartForm -> {
            Optional<Product> product = productRepository.findById(Long.valueOf(cartForm.getProductId()));
            if (product.isPresent()) {
                productsMap.put(cartForm, product.get());
            }
        });
        return productsMap;
    }

    private CartElementDto createCartElement(Product product, AddToCartForm form) {
        CartElementDto cartElementDto = new CartElementDto();
        cartElementDto.setProductId(product.getId());
        cartElementDto.setProductName(product.getName());
        cartElementDto.setQuantity(form.getQuantity());
        cartElementDto.setTotalPrice(Long.valueOf(calculatePrice(product, form.getQuantity())));
        return cartElementDto;
    }

    private int calculatePrice(Product product, int quantity) {
        List<PriceInterval> priceIntervals = product.getPriceIntervals();
        Optional<PriceInterval> price = priceIntervals.stream()
                .filter(priceInterval -> priceInterval.getIntervalMin() <= quantity && priceInterval.getIntervalMax() > quantity).findFirst();
        int totalPrice;
        if (price.isPresent()) {
            totalPrice = (int) (price.get().getPrice() * quantity);
        } else {
            totalPrice = (int) (priceIntervals.get(priceIntervals.size() - 1).getPrice() * quantity);
        }

        return totalPrice;
    }

    public int calculateTotalPrice(List<CartElementDto> cartElements) {
        return cartElements.stream().mapToInt(cartElement -> Math.toIntExact(cartElement.getTotalPrice())).sum();
    }
}
