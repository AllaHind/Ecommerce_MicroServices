package com.alla.productservice.service;


import com.alla.productservice.dto.ProductRequest;
import com.alla.productservice.dto.ProductResponse;
import com.alla.productservice.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

     ProductResponse getProduct(String code);
     List<ProductResponse> productList();
     ResponseEntity<?> saveProduct(ProductRequest productRequest);
     ResponseEntity<?> deleteProduct(Long id) throws RuntimeException;
     ResponseEntity<?> updateProduct(Product product, Long id);




}
