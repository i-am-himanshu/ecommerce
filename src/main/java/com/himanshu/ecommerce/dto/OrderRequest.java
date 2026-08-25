package com.himanshu.ecommerce.dto;

import com.himanshu.ecommerce.model.OrderStatus;

import java.time.LocalDateTime;

public class OrderRequest {

    private LocalDateTime orderDate;

    private OrderStatus orderStatus;

    private Long customer_id;

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

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}
