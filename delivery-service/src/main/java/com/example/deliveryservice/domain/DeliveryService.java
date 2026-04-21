package com.example.deliveryservice.domain;

import com.example.common.event.DeliveryAssignedEvent;
import com.example.common.exception.BusinessException;
import com.example.common.exception.ErrorCode;
import com.example.deliveryservice.adapter.in.web.dto.DeliveryResponse;
import com.example.deliveryservice.port.in.DeliveryUseCase;
import com.example.deliveryservice.port.out.DeliveryEventPublisherPort;
import com.example.deliveryservice.port.out.DeliveryRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryService implements DeliveryUseCase {

    private final DeliveryRepositoryPort deliveryRepositoryPort;
    private final DeliveryEventPublisherPort deliveryEventPublisherPort;

    @Override
    public void createDeliveryFromEvent(OrderCreatedEvent event) {
        // 1. 배달 생성
        Delivery delivery = Delivery.create(
                event.orderId(),
                event.customerId(),
                "기본 배달 주소"
        );

        // 2. 저장
        Delivery saved = deliveryRepositoryPort.save(delivery);

        // 3. 배달 할당 이벤트 발행
        deliveryEventPublisherPort.publishDeliveryAssigned(new DeliveryAssignedEvent(
                saved.id(),
                saved.orderId(),
                saved.customerId(),
                saved.address(),
                saved.createdAt()
        ));
    }

    @Override
    public DeliveryResponse getDeliveryByOrderId(Long orderId) {
        Delivery delivery = deliveryRepositoryPort.findByOrderId(orderId)
                .orElseThrow(() -> new BusinessException(ErrorCode.DELIVERY_NOT_FOUND));
        return DeliveryResponse.from(delivery);
    }
}
