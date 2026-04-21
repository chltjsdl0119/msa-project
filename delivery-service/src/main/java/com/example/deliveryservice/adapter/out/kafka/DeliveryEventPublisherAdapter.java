package com.example.deliveryservice.adapter.out.kafka;

import com.example.common.event.DeliveryAssignedEvent;
import com.example.deliveryservice.port.out.DeliveryEventPublisherPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeliveryEventPublisherAdapter implements DeliveryEventPublisherPort {

    private static final String DELIVERY_ASSIGNED_TOPIC = "delivery.assigned";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void publishDeliveryAssigned(DeliveryAssignedEvent event) {
        kafkaTemplate.send(DELIVERY_ASSIGNED_TOPIC, String.valueOf(event.orderId()), event);
        log.info("이벤트 발행 - topic: {}, orderId: {}", DELIVERY_ASSIGNED_TOPIC, event.orderId());
    }
}
