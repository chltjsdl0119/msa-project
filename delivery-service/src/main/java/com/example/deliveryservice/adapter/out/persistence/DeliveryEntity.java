package com.example.deliveryservice.adapter.out.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("deliveries")
public record DeliveryEntity(
        @Id Long id,
        Long orderId,
        Long customerId,
        Long riderId,
        String status,
        String address,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
