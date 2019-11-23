package com.brotech.localgoods.controller;

import com.brotech.localgoods.constants.Views;
import com.brotech.localgoods.enums.UnitType;
import com.brotech.localgoods.form.CreateProductForm;
import com.brotech.localgoods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    private static final String CATEGORIES_GROUPED = "categories_grouped";
    private static final String PRODUCT_UNITS = "product_units";
    private static final String CREATE_PRODUCT_FORM = "CreateProductForm";

    @Autowired
    private CategoryService categoryService;

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
}
