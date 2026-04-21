package com.example.deliveryservice.adapter.in.web;

import com.example.common.response.ApiResponse;
import com.example.deliveryservice.adapter.in.web.dto.DeliveryResponse;
import com.example.deliveryservice.port.in.DeliveryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryUseCase deliveryUseCase;  // 구현체가 아닌 인터페이스에 의존

    @GetMapping("/order/{orderId}")
    public ResponseEntity<ApiResponse<DeliveryResponse>> getDeliveryByOrderId(
            @PathVariable Long orderId) {
        return ResponseEntity.ok(ApiResponse.ok(deliveryUseCase.getDeliveryByOrderId(orderId)));
    }
}
