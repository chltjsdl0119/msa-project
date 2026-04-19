package com.example.orderservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("orders")
public record Order(
        @Id
        Long id,
        Long customerId,
        String status,
        BigDecimal totalPrice,
        LocalDateTime createdAt
) {
    public static Order create(Long customerId, BigDecimal totalPrice) {
        return new Order(
                null,
                customerId,
                "PENDING",
                totalPrice,
                LocalDateTime.now()
        );
    }
}