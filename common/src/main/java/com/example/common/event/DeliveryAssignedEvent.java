package com.example.common.event;

import java.time.LocalDateTime;

public record DeliveryAssignedEvent(
        Long deliveryId,
        Long orderId,
        Long customerId,
        String address,
        LocalDateTime assignedAt
) {
}
