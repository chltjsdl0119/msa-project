package com.example.deliveryservice.adapter.out.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeliveryJdbcRepository extends CrudRepository<DeliveryEntity, Long> {

    Optional<DeliveryEntity> findByOrderId(Long orderId);
}
