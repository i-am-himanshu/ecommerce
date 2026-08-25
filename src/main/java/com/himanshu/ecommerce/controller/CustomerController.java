package com.himanshu.ecommerce.controller;

import com.himanshu.ecommerce.dto.CustomerRequest;
import com.himanshu.ecommerce.dto.CustomerResponse;
import com.himanshu.ecommerce.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest) {
        return customerService.createCustomer(customerRequest);
    }
}
