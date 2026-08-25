package com.himanshu.ecommerce.dto;

import com.himanshu.ecommerce.model.OrderStatus;

import java.time.LocalDateTime;

public class OrderRequest {

    private LocalDateTime orderDate;

    private OrderStatus orderStatus;

    private Long customerId;

    public OrderRequest() {
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
