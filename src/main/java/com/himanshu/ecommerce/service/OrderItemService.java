package com.himanshu.ecommerce.service;

import com.himanshu.ecommerce.dto.OrderItemRequest;
import com.himanshu.ecommerce.model.Order;
import com.himanshu.ecommerce.model.OrderItem;
import com.himanshu.ecommerce.model.Product;
import com.himanshu.ecommerce.repository.OrderItemRepository;
import com.himanshu.ecommerce.repository.OrderRepository;
import com.himanshu.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderItemService(OrderItemRepository orderItemRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public OrderItem createOrderItem(OrderItemRequest orderItemRequest) {
        Order order = orderRepository.findById(orderItemRequest.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found."));

        Product product = productRepository.findById(orderItemRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found."));

        OrderItem orderItem = new OrderItem();

        orderItem.setOrder(order);
        orderItem.setPrice(orderItemRequest.getPrice());
        orderItem.setProduct(product);
        orderItem.setQuantity(orderItemRequest.getQuantity());

        return orderItemRepository.save(orderItem);
    }
}
