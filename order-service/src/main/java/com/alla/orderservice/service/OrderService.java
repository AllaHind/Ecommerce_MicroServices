package com.alla.orderservice.service;

import com.alla.orderservice.dto.OrderRequest;
import com.alla.orderservice.dto.OrderResponse;
import com.alla.orderservice.entity.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    ResponseEntity<?> placeOrder(OrderRequest orderRequest);
    OrderResponse getOrder(String code);
    List<OrderResponse> getAllOrders();
    ResponseEntity<?> deleteOrder(Long id);
    ResponseEntity<?> updateOrder(OrderRequest orderRequest,Long id);

}
