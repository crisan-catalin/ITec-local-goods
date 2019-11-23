package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Views;
import com.brotech.localgoods.enums.UnitType;
import com.brotech.localgoods.form.CreateProductForm;
import com.brotech.localgoods.service.CategoryService;
import com.brotech.localgoods.service.impl.DefaultProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.brotech.localgoods.constants.Views.ERROR_PAGE;
import static com.brotech.localgoods.constants.Views.PRODUCT_DETAILS_PAGE;

@Controller
@RequestMapping("/products")
public class ProductController {

    private static final String CATEGORIES_GROUPED = "categories_grouped";
    private static final String PRODUCT_UNITS = "product_units";
    private static final String CREATE_PRODUCT_FORM = "CreateProductForm";
    private static final String PRODUCT_ID = "productId";
    private static final String PRODUCT_DETAILS = "productDetails";
    private static final String PRODUCTS = "productList";
    private static final String IS_LIST = "isList";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DefaultProductService productService;

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute(CATEGORIES_GROUPED, categoryService.getAllCategoriesAndSubCategories());
        model.addAttribute(PRODUCT_UNITS, UnitType.values());
        model.addAttribute(CREATE_PRODUCT_FORM, new CreateProductForm());
        return Views.ADD_PRODUCT_PAGE;
    }

    @PostMapping("/add")
    public void createProduct(@ModelAttribute(CREATE_PRODUCT_FORM) CreateProductForm form) {
    }

    @GetMapping("/list")
    public String getProducts(Model model) {
        model.addAttribute(PRODUCTS, productService.getProducts());
        model.addAttribute(IS_LIST, Boolean.TRUE);
        return Views.PRODUCTS_PAGE;
    }

    @GetMapping("/grid")
    public String getProductsGrid(Model model) {
        model.addAttribute(PRODUCTS, productService.getProducts());
        model.addAttribute(IS_LIST, Boolean.FALSE);
        return Views.PRODUCTS_PAGE;
    }

    @GetMapping("/details/{productId}")
    public String getProdut(@PathVariable("productId") String productId, Model model) {
        try {
            model.addAttribute(PRODUCT_DETAILS, productService.getProductDetails(Long.parseLong(productId)));
            model.addAttribute(PRODUCT_ID, productId);
            return PRODUCT_DETAILS_PAGE;
        } catch (Exception e) {
            return ERROR_PAGE;
        }
    }
}
