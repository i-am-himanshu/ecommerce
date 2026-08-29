package com.himanshu.ecommerce.controller;

import com.himanshu.ecommerce.dto.CustomerRequest;
import com.himanshu.ecommerce.dto.CustomerResponse;
import com.himanshu.ecommerce.service.CustomerService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public CustomerResponse getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }
}
