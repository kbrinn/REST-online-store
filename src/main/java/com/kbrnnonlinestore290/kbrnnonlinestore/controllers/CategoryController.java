package com.kbrnnonlinestore290.kbrnnonlinestore.controllers;

import com.kbrnnonlinestore290.kbrnnonlinestore.common.ApiResponse;
import com.kbrnnonlinestore290.kbrnnonlinestore.model.Category;
import com.kbrnnonlinestore290.kbrnnonlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> body = categoryService.listCategories();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("category")
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
        if (Objects.nonNull(categoryService.readCategory(category.getCategoryName()))) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Attempt to create duplicate category"), HttpStatus.CONFLICT);
        }
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "category created"), HttpStatus.CREATED);
    }


    @PostMapping("/update/{categoryID}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") int categoryID, @Valid @RequestBody Category category) {
        if (Objects.isNull(categoryService.readCategory(category.getCategoryName()))) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Attempt to update non-existent category"), HttpStatus.NOT_FOUND);
        }
        categoryService.updateCategory(categoryID);
        return new ResponseEntity<>(new ApiResponse(true, "category updated"), HttpStatus.OK);

    }


}
