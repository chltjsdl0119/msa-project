package com.example.deliveryservice.domain;

import java.time.LocalDateTime;

public record Delivery(
        Long id,
        Long orderId,
        Long customerId,
        Long riderId,
        String status,
        String address,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static Delivery create(Long orderId, Long customerId, String address) {
        return new Delivery(
                null,
                orderId,
                customerId,
                null,
                "ASSIGNED",
                address,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
