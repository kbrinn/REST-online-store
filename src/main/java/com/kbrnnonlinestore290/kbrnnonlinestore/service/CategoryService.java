package com.kbrnnonlinestore290.kbrnnonlinestore.service;


import com.kbrnnonlinestore290.kbrnnonlinestore.repository.CategoryRepository;
import com.kbrnnonlinestore290.kbrnnonlinestore.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category readCategory(String categoryName) {
        return categoryRepository.findCategoryName(categoryName);
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> readCategory(int categoryID) {
        return categoryRepository.findById(categoryID);
    }

    public void updateCategory(int categoryID) {
        Category category = categoryRepository.findById(categoryID).get();
        category.setCategoryName(category.getCategoryName());
        category.setDescription(category.getDescription());
        category.setImageUrl(category.getImageUrl());
        categoryRepository.save(category);

    }

}
