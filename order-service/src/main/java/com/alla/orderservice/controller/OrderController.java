package com.alla.orderservice.controller;


import com.alla.orderservice.dto.OrderRequest;
import com.alla.orderservice.dto.OrderResponse;
import com.alla.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
   private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest)
    {
        return orderService.placeOrder(orderRequest);
    }
    @GetMapping("{code}")
    public OrderResponse getOrder(@PathVariable("code") String code) {
        return orderService.getOrder(code);
    }
    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id) {
        return orderService.deleteOrder(id);
    }

    public ResponseEntity<?> updateOrder(OrderRequest orderRequest, Long id) {
        return orderService.updateOrder(orderRequest, id);
    }
}
