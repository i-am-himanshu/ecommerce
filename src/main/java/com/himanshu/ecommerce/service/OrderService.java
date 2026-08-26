package com.himanshu.ecommerce.service;

import com.himanshu.ecommerce.dto.OrderRequest;
import com.himanshu.ecommerce.dto.OrderResponse;
import com.himanshu.ecommerce.model.Customer;
import com.himanshu.ecommerce.model.Order;
import com.himanshu.ecommerce.repository.CustomerRepository;
import com.himanshu.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    private OrderResponse mapToOrderResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setCustomerId(order.getCustomer().getId());
        orderResponse.setId(order.getId());
        orderResponse.setOrderDate(order.getOrderDate());
        orderResponse.setOrderStatus(order.getOrderStatus());

        return orderResponse;
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {
        Customer customer = customerRepository.findById(orderRequest.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found."));

        Order order = new Order();

        order.setOrderDate(orderRequest.getOrderDate());
        order.setOrderStatus(orderRequest.getOrderStatus());
        order.setCustomer(customer);

        Order savedOrder = orderRepository.save(order);

        return mapToOrderResponse(savedOrder);
    }
}
