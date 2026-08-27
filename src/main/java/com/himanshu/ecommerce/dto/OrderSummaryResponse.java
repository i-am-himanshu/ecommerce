package com.himanshu.ecommerce.dto;

import com.himanshu.ecommerce.model.OrderStatus;

import java.time.LocalDateTime;

public class OrderSummaryResponse {

    private Long id;

    private LocalDateTime orderDate;

    private OrderStatus orderStatus;

    public OrderSummaryResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
