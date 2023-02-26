package com.alla.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class ProductResponse {
    private Long id;
    private String code;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private String imageUrl;
}
