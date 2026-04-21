package com.example.deliveryservice.port.out;

import com.example.common.event.DeliveryAssignedEvent;

public interface DeliveryEventPublisherPort {

    void publishDeliveryAssigned(DeliveryAssignedEvent event);
}
