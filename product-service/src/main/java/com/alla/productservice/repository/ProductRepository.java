package com.alla.productservice.repository;

import com.alla.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByCode(String code);
}
