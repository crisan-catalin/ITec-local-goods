package com.brotech.localgoods.service;

import com.brotech.localgoods.dto.CartElementDto;
import com.brotech.localgoods.form.AddToCartForm;
import com.brotech.localgoods.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductDetails(Long prodctId);

    List<Product> getCartProducts(List<AddToCartForm> cartProducts);

    List<CartElementDto> getCartElements(List<AddToCartForm> cartProdycts);
}
