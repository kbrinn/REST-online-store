package com.kbrnnonlinestore290.kbrnnonlinestore.service;

import com.kbrnnonlinestore290.kbrnnonlinestore.repository.ProductRepository;
import com.kbrnnonlinestore290.kbrnnonlinestore.DTO.ProductDTO;
import com.kbrnnonlinestore290.kbrnnonlinestore.model.Category;
import com.kbrnnonlinestore290.kbrnnonlinestore.model.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public static Product getProduct(ProductDTO productDTO, Category category) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setImageURL((productDTO.getImageURL()));
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;
    }

    public void addProduct(ProductDTO productDTO, Category category) {
        Product product = getProduct(productDTO, category);
        productRepository.save(product);
    }

    public List<ProductDTO> listProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : products) {
            productDTOList.add(new ProductDTO(product));
        }
        return productDTOList;
    }

    //update a product method
    public void updateProduct(int productID, ProductDTO productDTO, Category category) {
        Product product = getProduct(productDTO, category);
        product.setId(productID);
        productRepository.save(product);

    }
}