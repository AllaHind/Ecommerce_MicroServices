package com.alla.orderservice.repository;

import com.alla.orderservice.dto.OrderResponse;
import com.alla.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByCode(String code);
}
