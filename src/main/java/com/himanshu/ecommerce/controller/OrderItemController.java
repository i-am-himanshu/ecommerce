package com.himanshu.ecommerce.controller;

import com.himanshu.ecommerce.dto.OrderItemRequest;
import com.himanshu.ecommerce.dto.OrderItemResponse;
import com.himanshu.ecommerce.model.OrderItem;
import com.himanshu.ecommerce.service.OrderItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping
    public OrderItemResponse createOrderItem(@RequestBody OrderItemRequest orderItemRequest) {
        return orderItemService.createOrderItem(orderItemRequest);
    }
}
