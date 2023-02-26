package com.alla.orderservice.dto;

import com.alla.orderservice.entity.OrderItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class OrderResponse {
    private Long id;
    private String code;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
    private double totalPrice;
    private Date orderDate;
}
