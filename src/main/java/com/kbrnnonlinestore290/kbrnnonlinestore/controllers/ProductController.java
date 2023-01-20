package com.kbrnnonlinestore290.kbrnnonlinestore.controllers;


import com.kbrnnonlinestore290.kbrnnonlinestore.DTO.ProductDTO;
import com.kbrnnonlinestore290.kbrnnonlinestore.common.ApiResponse;
import com.kbrnnonlinestore290.kbrnnonlinestore.model.Category;
import com.kbrnnonlinestore290.kbrnnonlinestore.service.CategoryService;
import com.kbrnnonlinestore290.kbrnnonlinestore.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import javax.validation.Valid;
import java.util.Objects;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@Valid @RequestBody ProductDTO productDTO) {
//        Optional<Category> optionalCategory = categoryService.readCategory(productDTO.getCategoryID());
        if (Objects.isNull(categoryService.readCategory(productDTO.getCategoryID()))) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Attempt to add product to non-existent category"), HttpStatus.CONFLICT);
        }
        Category category = categoryService.readCategory(productDTO.getCategoryID()).get();
        productService.addProduct(productDTO,category);
        return new ResponseEntity<>(new ApiResponse(true, "product created"), HttpStatus.CREATED);



    }
}
