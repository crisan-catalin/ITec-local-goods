package com.brotech.localgoods.repository;

import com.brotech.localgoods.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllBySupercategoryId(Long id);

    List<Category> findAllBySupercategoryIsNull();

    List<Category> findAllBySupercategoryIsNotNull();
}
