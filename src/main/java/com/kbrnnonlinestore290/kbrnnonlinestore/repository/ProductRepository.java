package com.kbrnnonlinestore290.kbrnnonlinestore.repository;

import com.kbrnnonlinestore290.kbrnnonlinestore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
