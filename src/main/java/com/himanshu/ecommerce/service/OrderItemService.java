package com.himanshu.ecommerce.service;

import com.himanshu.ecommerce.dto.OrderItemRequest;
import com.himanshu.ecommerce.dto.OrderItemResponse;
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

    private OrderItemResponse mapToOrderItemResponse(OrderItem orderItem) {
        OrderItemResponse orderItemResponse = new OrderItemResponse();

        orderItemResponse.setId(orderItem.getId());
        orderItemResponse.setOrderId(orderItem.getOrder().getId());
        orderItemResponse.setPrice(orderItem.getPrice());
        orderItemResponse.setProductId(orderItem.getProduct().getId());
        orderItemResponse.setQuantity(orderItem.getQuantity());

        return orderItemResponse;
    }

    public OrderItemResponse createOrderItem(OrderItemRequest orderItemRequest) {
        Order order = orderRepository.findById(orderItemRequest.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found."));

        Product product = productRepository.findById(orderItemRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found."));

        OrderItem orderItem = new OrderItem();

        orderItem.setOrder(order);
        orderItem.setPrice(orderItemRequest.getPrice());
        orderItem.setProduct(product);
        orderItem.setQuantity(orderItemRequest.getQuantity());

        OrderItem savedOrderItem = orderItemRepository.save(orderItem);

        return mapToOrderItemResponse(savedOrderItem);
    }
}
