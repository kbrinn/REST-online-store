package com.kbrnnonlinestore290.kbrnnonlinestore.repository;

import com.kbrnnonlinestore290.kbrnnonlinestore.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryName(String categoryName);
}

