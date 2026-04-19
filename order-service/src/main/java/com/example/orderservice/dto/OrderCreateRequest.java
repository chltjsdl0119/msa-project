package com.example.orderservice.dto;

import java.math.BigDecimal;

public record OrderCreateRequest(
        Long customerId,
        BigDecimal totalPrice
) {

}
