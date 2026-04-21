package com.example.deliveryservice.adapter.out.persistence;

import com.example.deliveryservice.domain.Delivery;
import com.example.deliveryservice.port.out.DeliveryRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeliveryRepositoryAdapter implements DeliveryRepositoryPort {

    private final DeliveryJdbcRepository jdbcRepository;

    @Override
    public Delivery save(Delivery delivery) {
        DeliveryEntity entity = toEntity(delivery);
        DeliveryEntity saved = jdbcRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Delivery> findByOrderId(Long orderId) {
        return jdbcRepository.findByOrderId(orderId).map(this::toDomain);
    }

    // Domain → Entity 변환
    private DeliveryEntity toEntity(Delivery delivery) {
        return new DeliveryEntity(
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

    // Entity → Domain 변환
    private Delivery toDomain(DeliveryEntity entity) {
        return new Delivery(
                entity.id(),
                entity.orderId(),
                entity.customerId(),
                entity.riderId(),
                entity.status(),
                entity.address(),
                entity.createdAt(),
                entity.updatedAt()
        );
    }
}
