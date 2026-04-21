package com.example.deliveryservice.adapter.in.kafka;

import com.example.deliveryservice.port.in.DeliveryUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedEventConsumer {

    private final DeliveryUseCase deliveryUseCase;

    @KafkaListener(
            topics = "order.created",
            groupId = "delivery-service-group"
    )
    public void consume(OrderCreatedEvent event) {
        log.info("이벤트 수신 - orderId: {}, customerId: {}", event.orderId(), event.customerId());
        deliveryUseCase.createDeliveryFromEvent(event);
    }
}
