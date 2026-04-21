package com.example.deliveryservice.adapter.in.web.dto;

import com.example.deliveryservice.domain.Delivery;

import java.time.LocalDateTime;

public record DeliveryResponse(
        Long id,
        Long orderId,
        Long customerId,
        Long riderId,
        String status,
        String address,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static DeliveryResponse from(Delivery delivery) {
        return new DeliveryResponse(
                delivery.id(),
                delivery.orderId(),
                delivery.customerId(),
                delivery.riderId(),
                delivery.status(),
                delivery.address(),
                delivery.createdAt(),
                delivery.updatedAt()
        );
    }
}
