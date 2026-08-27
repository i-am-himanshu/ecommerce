package com.himanshu.ecommerce.dto;

import java.util.List;

public class CustomerResponse {

    private Long id;

    private String name;

    private String email;

    private List<OrderSummaryResponse> orders;

    public CustomerResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderSummaryResponse> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderSummaryResponse> orders) {
        this.orders = orders;
    }
}
