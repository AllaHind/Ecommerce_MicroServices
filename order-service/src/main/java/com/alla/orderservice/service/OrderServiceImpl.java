package com.alla.orderservice.service;

import com.alla.orderservice.dto.OrderItemDto;
import com.alla.orderservice.dto.OrderRequest;
import com.alla.orderservice.dto.OrderResponse;
import com.alla.orderservice.entity.Order;
import com.alla.orderservice.entity.OrderItem;
import com.alla.orderservice.repository.OrderRepository;
import com.alla.orderservice.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public ResponseEntity<?> placeOrder(OrderRequest orderRequest) {
        // Convert OrderItemsDto To OrderItems
        List<OrderItem> orderItems =
                orderRequest.getOrderItemsDto().stream().map(orderItemDto -> mapToOrderItem(orderItemDto)).toList();
        Order order = Order.builder()
                .orderItems(orderItems)
                .build();

        //Set Random Code for the order
        order.setCode(UUID.randomUUID().toString());
        //Set the current date for the order
        order.setOrderDate(new Date());
        //calculate the total price of all the OrderItems and Set it for the order
        order.setTotalPrice(sumPrice(orderItems));
        orderRepository.save(order);
        return ResponseEntity.ok(new MessageResponse("Order has been saved successfully"));


    }

    private  long sumPrice(List<OrderItem> orderItems)
    {
        long sum=0L;
        for(OrderItem orderItem:orderItems)
        {
            sum+=orderItem.getPrice()*orderItem.getQuantity();
        }
        return  sum;
    }

    private OrderResponse mapToOrderResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .code(order.getCode())
                .orderItems(order.getOrderItems())
                .orderDate(order.getOrderDate())
                .totalPrice(order.getTotalPrice())
                .build();

    }

    private OrderItem mapToOrderItem(OrderItemDto orderItemDto) {
        return OrderItem.builder()
                .quantity(orderItemDto.getQuantity())
                .price(orderItemDto.getPrice())
                .build();

    }

    public OrderResponse getOrder(String code) {
        Order order = orderRepository.findByCode(code);
        return mapToOrderResponse(order);
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order -> mapToOrderResponse(order)).toList();
    }

    @Transactional
    public ResponseEntity<?> deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Order with id " + id + " does not exist"));
        orderRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Order has been deleted successfully"));

    }


    public ResponseEntity<?> updateOrder(OrderRequest orderRequest, Long id) {

        return null;
    }
}
