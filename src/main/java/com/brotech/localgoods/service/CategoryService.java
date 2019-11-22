package com.brotech.localgoods.service;

import com.brotech.localgoods.model.Category;
import com.brotech.localgoods.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Map<Category, List<Category>> getAllCategoriesAndSubCategories() {
        List<Category> baseCategories = categoryRepository.findAllBySupercategoryIsNull();
        Map<Category, List<Category>> groupedCategories = new HashMap<>();
        baseCategories.forEach(category -> {
            if (category.getSupercategory() == null) {
                groupedCategories.put(category, categoryRepository.findAllBySupercategoryId(category.getId()));
            }
        });

        return groupedCategories;
    }
}
