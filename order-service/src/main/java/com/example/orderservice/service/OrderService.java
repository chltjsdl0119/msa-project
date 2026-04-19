package com.example.orderservice.service;

import com.example.common.exception.BusinessException;
import com.example.common.exception.ErrorCode;
import com.example.orderservice.domain.Order;
import com.example.orderservice.dto.OrderCreateRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponse createOrder(OrderCreateRequest request) {
        Order order = Order.create(request.customerId(), request.totalPrice());
        Order saved = orderRepository.save(order);
        return OrderResponse.from(saved);
    }

    public OrderResponse getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new BusinessException(ErrorCode.ORDER_NOT_FOUND));
        return OrderResponse.from(order);
    }
}
