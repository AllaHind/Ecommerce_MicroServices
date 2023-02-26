package com.alla.productservice.controller;


import com.alla.productservice.dto.ProductRequest;
import com.alla.productservice.dto.ProductResponse;
import com.alla.productservice.entity.Product;
import com.alla.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;

    @GetMapping("/{code}")
    public ProductResponse getProduct(@PathVariable("code")String code) {
        return productService.getProduct(code);
    }
   @GetMapping
    public List<ProductResponse> productList() {
        return productService.productList();
    }
    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) throws RuntimeException {
        return productService.deleteProduct(id);
    }

    public ResponseEntity<?> updateProduct(Product product, Long id) {
        return productService.updateProduct(product, id);
    }
}
