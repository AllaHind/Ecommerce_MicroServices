package com.alla.orderservice.dto;

import com.alla.orderservice.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class OrderRequest {
    private List<OrderItemDto> orderItemsDto;

}
