package com.example.orderservice.dto;


import com.example.orderservice.domain.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponse(
        Long id,
        Long customerId,
        String status,
        BigDecimal totalPrice,
        LocalDateTime createdAt
) {
    public static OrderResponse from(Order order) {
        return new OrderResponse(
                order.id(),
                order.customerId(),
                order.status(),
                order.totalPrice(),
                order.createdAt()
        );
    }
}
