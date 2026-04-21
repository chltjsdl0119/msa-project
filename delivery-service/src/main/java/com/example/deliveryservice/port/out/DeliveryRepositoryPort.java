package com.example.deliveryservice.port.out;

import com.example.deliveryservice.domain.Delivery;

import java.util.Optional;

public interface DeliveryRepositoryPort {

    Delivery save(Delivery delivery);

    Optional<Delivery> findByOrderId(Long orderId);
}
