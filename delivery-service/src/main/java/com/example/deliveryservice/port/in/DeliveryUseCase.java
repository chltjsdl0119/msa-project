package com.example.deliveryservice.port.in;

import com.example.deliveryservice.adapter.in.web.dto.DeliveryResponse;

public interface DeliveryUseCase {

    void createDeliveryFromEvent(OrderCreatedEvent event);

    DeliveryResponse getDeliveryByOrderId(Long orderId);
}
