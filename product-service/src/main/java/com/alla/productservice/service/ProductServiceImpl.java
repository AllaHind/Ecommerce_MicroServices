package com.alla.productservice.service;

import com.alla.productservice.dto.ProductRequest;
import com.alla.productservice.dto.ProductResponse;
import com.alla.productservice.entity.Product;
import com.alla.productservice.repository.ProductRepository;
import com.alla.productservice.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    public ProductResponse getProduct(String code) {

        Product product = productRepository.findByCode(code);
        return mapToProductResponse(product);

    }

    public List<ProductResponse> productList() {

        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> mapToProductResponse(product)).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .code(product.getCode())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    public ResponseEntity<?> saveProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .quantity(productRequest.getQuantity())
                .imageUrl(productRequest.getImageUrl())
                .build();
        //To Generate a random code for a product
        product.setCode(RandomAlphaNumericCodeGenerator.generateCode(6));
        productRepository.save(product);
        return ResponseEntity.ok(new MessageResponse("Product has been saved successfully"));


    }

    @Transactional
    public ResponseEntity<?> deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Product with id " + id + " does not exist"));
        productRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Product has been deleted successfully"));

    }


    public ResponseEntity<?> updateProduct(Product product, Long id) {
        return null;
    }
}
